package com.rtrk.netbeansllvmsdk.td.lexer;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import com.rtrk.netbeansllvmsdk.td.jcclexer.JavaCharStream;
import com.rtrk.netbeansllvmsdk.td.jcclexer.TableGenParserTokenManager;
import com.rtrk.netbeansllvmsdk.td.jcclexer.Token;

class TDLexer implements Lexer<TDTokenId> {
    
    private LexerRestartInfo<TDTokenId> info;
    private TableGenParserTokenManager tableGenParserTokenManager;

    TDLexer(LexerRestartInfo<TDTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream(info.input());
        tableGenParserTokenManager = new TableGenParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<TDTokenId> nextToken() {
        Token token = tableGenParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(TDLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}
