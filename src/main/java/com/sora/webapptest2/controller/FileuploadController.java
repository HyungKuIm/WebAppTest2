package com.sora.webapptest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "fileupload")
public class FileuploadController {

    @RequestMapping(method = RequestMethod.GET)
    public void setUpForm(Model model) {

    }

    @RequestMapping(value="/single", method = RequestMethod.POST)
    public String single(@RequestParam MultipartFile file, HttpServletRequest request) {
        String filename = "";
        if (file != null && !file.isEmpty()) {
            filename = file.getOriginalFilename();
            ServletContext application = request.getSession().getServletContext();
            String path = application.getRealPath("/images/");
            try {
                file.transferTo(new File(path + filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "complete";
        } else {
            return "fail";
        }
    }
}
