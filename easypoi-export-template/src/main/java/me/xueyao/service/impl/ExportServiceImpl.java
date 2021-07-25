package me.xueyao.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import lombok.SneakyThrows;
import me.xueyao.domain.Employee;
import me.xueyao.service.ExportService;
import me.xueyao.util.FTPUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Simon.Xue
 * @date 2021/7/22 11:08 下午
 **/
@Service
public class ExportServiceImpl implements ExportService {

    @Resource
    private FTPUtil ftpUtil;
    @Value("${template.employee}")
    private String employeeTemplateName;

    @SneakyThrows
    @Override
    public void templateTest(HttpServletResponse response) {
        String localPathName = ftpUtil.localPathName(employeeTemplateName);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment;filename="+ IdUtil.getSnowflake(0,0).nextIdStr()+".xlsx");
        Map<String, Object> resultMap = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setJobNumber("0001");
        employee.setUsername("小码农薛尧");
        employee.setPhone("1234567901");
        employee.setEmail("xueyao.me@gmail.com");
        employeeList.add(employee);
        List<Map<String, Object>> maps = employeeList.stream().map(a -> {
            Map<String, Object> map = BeanUtil.beanToMap(a);
            return map;
        }).collect(Collectors.toList());
        resultMap.put("employees", maps);
        TemplateExportParams params = new TemplateExportParams(localPathName, "test");
        Workbook workbook = ExcelExportUtil.exportExcel(params, resultMap);
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }
}
