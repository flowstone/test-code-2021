package me.xueyao.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Simon.Xue
 * @date 2021/7/22 11:08 下午
 **/
public interface ExportService {
    /**
     * 根据模板导出Excel
     * @param response
     */
    void templateTest(HttpServletResponse response);
}
