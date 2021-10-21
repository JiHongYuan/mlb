package com.github.mlb.auth.controller;

import com.github.mlb.auth.model.AccessToken;
import com.github.mlb.auth.properties.OAuth2Properties;
import com.github.mlb.common.utils.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JiHongYuan
 * @date 2021/9/22 16:09
 */
@RestController
public class LoginController {
}
