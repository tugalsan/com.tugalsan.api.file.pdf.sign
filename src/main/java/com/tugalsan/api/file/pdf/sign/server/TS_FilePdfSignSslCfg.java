package com.tugalsan.api.file.pdf.sign.server;

import com.tugalsan.api.charset.client.TGS_CharSet;
import com.tugalsan.api.charset.client.TGS_CharSetCast;
import com.tugalsan.api.url.client.TGS_Url;
import java.nio.file.Path;

public class TS_FilePdfSignSslCfg {

    public TS_FilePdfSignSslCfg(Path keyStorePath, CharSequence keyStorePass) {
        this(keyStorePath, keyStorePass, null);//"https://freetsa.org/tsr";
    }

    public TS_FilePdfSignSslCfg(Path keyStorePath, CharSequence keyStorePass, TGS_Url tsa) {
        this.keyStorePath = keyStorePath;
        this.keyStorePass = keyStorePass.toString();
        this.tsa = tsa;
        var fn = TGS_CharSetCast.current().toLowerCase(keyStorePath.getFileName().toString());
        if (fn.endsWith(".p12")) {
            keyType = "PKCS12";
        } else if (fn.endsWith(".jks")) {
            keyType = "JKS";
        }
    }
    private Path keyStorePath;
    private String keyStorePass, keyType = null;
    private TGS_Url tsa;

    public Path getKeyStorePath() {
        return keyStorePath;
    }

    public String getKeyStorePass() {
        return keyStorePass;
    }

    public TGS_Url getTsa() {
        return tsa;
    }

    public void setTsa(TGS_Url newTsa) {
        tsa = newTsa;
    }

    public String getType() {
        return keyType;
    }

    @Override
    public String toString() {
        return TS_FilePdfSignSslCfg.class.getSimpleName() + "{" + "keyStorePath=" + keyStorePath + ", keyStorePass=" + keyStorePass + ", tsa=" + tsa + ", keyType=" + keyType + '}';
    }
}
