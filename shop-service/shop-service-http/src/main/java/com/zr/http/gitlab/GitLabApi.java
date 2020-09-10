package com.zr.http.gitlab;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * gitlab批量转移
 * @author zhangr
 * 2020/9/8 10:48
 */
@RestController
@Api("GitLab API")
public class GitLabApi {
    @Resource
    private RestTemplate restTemplate;

    //旧仓库地址
    private final static String OLD_REPO_URL = "http://ip:port";
    //旧仓库的Personal Access Tokens
    private final static String OLD_PRESONAL_ACESS_TOKEN = "xxx";

    //新仓库地址
    private final static String NEW_REPO_URL = "http://ip:port";
    //新仓库的Personal Access Tokens
    private final static String NEW_PRESONAL_ACESS_TOKEN = "xxx";
    //记录项目对应的规划目录
    private Map<String, String> groupName = new HashMap<>();
    private Map<String, String> groupDesc = new HashMap<>();
    private Map<String, Integer> groupId = new HashMap<>();

    {
        groupName.put("项目名", "对应组名");
        groupDesc.put("组名", "组描述信息");
    }


    @GetMapping("createGroup")
    public String createGroup() {

        return "ok";
    }

    @GetMapping("createProject")
    public String createProject() {
        //创建组
        for (Map.Entry<String, String> entry : groupDesc.entrySet()) {
            try {
                String newUrl = NEW_REPO_URL + "/api/v4/groups";
                HttpHeaders newHeader = new HttpHeaders();
                newHeader.set("PRIVATE-TOKEN", NEW_PRESONAL_ACESS_TOKEN);
                newHeader.setContentType(MediaType.APPLICATION_JSON);
                JSONObject param = new JSONObject();
                param.put("name", entry.getKey());
                param.put("path", entry.getKey());
                param.put("description", entry.getValue());
                param.put("parent_id", 1862);
                HttpEntity<String> newEntity = new HttpEntity<>(param.toString(), newHeader);
                ResponseEntity<JSONObject> res = restTemplate.postForEntity(newUrl, newEntity, JSONObject.class);
                groupId.put(entry.getKey(), res.getBody().getIntValue("id"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //根据旧的项目创建新的项目
        JSONArray projects = getProjects();
        for (Object pro : projects) {
            Map project = (Map) pro;
            try {
                String newUrl = NEW_REPO_URL + "/api/v4/projects";
                HttpHeaders newHeader = new HttpHeaders();
                newHeader.set("PRIVATE-TOKEN", NEW_PRESONAL_ACESS_TOKEN);
                newHeader.setContentType(MediaType.APPLICATION_JSON);
                JSONObject param = new JSONObject();

                String projectName = (String) project.get("name");

                param.put("name", projectName);
                param.put("path", project.get("path"));
                param.put("description", project.get("description"));
                if (groupName.containsKey(projectName))
                    param.put("namespace_id", groupId.get(groupName.get(projectName)));
                else
                    param.put("namespace_id", groupId.get("others"));

                HttpEntity<String> newEntity = new HttpEntity<>(param.toString(), newHeader);
                ResponseEntity<JSONObject> res = restTemplate.postForEntity(newUrl, newEntity, JSONObject.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "ok";
    }

    public JSONArray getProjects() {
        //获取全部项目
        String oldUrl = OLD_REPO_URL + "/api/v4/projects?per_page=1000";
        HttpHeaders oldHeader = new HttpHeaders();
        oldHeader.add("PRIVATE-TOKEN", OLD_PRESONAL_ACESS_TOKEN);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, oldHeader);
        ResponseEntity<JSONArray> oldRes = restTemplate.exchange(oldUrl, HttpMethod.GET, entity, JSONArray.class);
        JSONArray projects = oldRes.getBody();
        return projects;
    }

    public JSONArray getNewProjects() {
        //获取全部项目
        String oldUrl = NEW_REPO_URL + "/api/v4/projects?per_page=1000";
        HttpHeaders oldHeader = new HttpHeaders();
        oldHeader.add("PRIVATE-TOKEN", NEW_PRESONAL_ACESS_TOKEN);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(null, oldHeader);
        ResponseEntity<JSONArray> oldRes = restTemplate.exchange(oldUrl, HttpMethod.GET, entity, JSONArray.class);
        JSONArray projects = oldRes.getBody();
        return projects;
    }

    @GetMapping("generateShell")
    public String generateShell() {
        JSONArray oldProjects = getProjects();
        JSONArray newProjects = getNewProjects();

        Map<String, String> name = new HashMap<>();

        //old
        for (Object pro : oldProjects) {
            Map project = (Map) pro;
            try {
                Object projectName = project.get("name");
                String url = (String) project.get("http_url_to_repo");
                //如果用户名密码包含@，转为%40
                url = StringUtils.replace(url, "http://", "git clone --mirror http://userName:password@");
                System.out.println(url);
                name.put((String) projectName, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("===============================");

        //new
        for (Object pro : newProjects) {
            Map project = (Map) pro;
            try {
                Object projectName = project.get("name");
                String url = (String) project.get("http_url_to_repo");
                //如果用户名密码包含@，转为%40
                url = StringUtils.replace(url, "http://", "git push --mirror http://userName:password@");
                if (name.containsKey((String) projectName)) {
                    System.out.println("cd /root/code/" + project.get("path") + ".git");
                    System.out.println(url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "ok";
    }
}
