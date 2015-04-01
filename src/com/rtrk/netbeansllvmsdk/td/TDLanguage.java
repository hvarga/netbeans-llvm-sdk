package com.rtrk.netbeansllvmsdk.td;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import com.rtrk.netbeansllvmsdk.td.lexer.TDTokenId;


@LanguageRegistration(mimeType = "text/x-td")
public class TDLanguage extends DefaultLanguageConfig {
    @Override
    public Language getLexerLanguage() {
        return TDTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "TD";
    }
}
