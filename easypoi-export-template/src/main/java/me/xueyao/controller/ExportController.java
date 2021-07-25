package me.xueyao.controller;

import me.xueyao.service.ExportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Simon.Xue
 * @date 2021/7/22 11:05 下午
 **/
@RequestMapping("/export")
@RestController
public class ExportController {

    @Resource
    private ExportService exportService;
    /**
     * 测试导出功能
     * @param response
     */
    @PostMapping("/test")
    public void test(HttpServletResponse response) {
        exportService.templateTest(response);
    }
}
