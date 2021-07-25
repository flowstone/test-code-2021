package me.xueyao.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpMode;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * @author Simon.Xue
 * @date 2021/7/22 11:24 下午
 **/
@Configuration
public class FTPUtil {

    @Value("${ftp.host}")
    private String host;
    @Value("${ftp.port}")
    private Integer port;
    @Value("${ftp.username}")
    private String username;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.mode}")
    private String mode;
    @Value("${ftp.remotePath}")
    private String remotePath;
    @Value("${ftp.localPath}")
    private String localPath;

    /**
     * 拷贝FTP中的文件到本地
     * @param fileName  ftp中的文件名
     * @return
     */
    @SneakyThrows
    public String localPathName(String fileName) {
        Ftp ftp = new Ftp(host, port, username, password, Charset.defaultCharset());
        ftp.setMode(FtpMode.Passive.name().equals(mode)? FtpMode.Passive: FtpMode.Active);
        String localName = localPath + fileName;
        ftp.download(remotePath, fileName, FileUtil.file(localName));
        ftp.close();
        return localName;
    }
}
