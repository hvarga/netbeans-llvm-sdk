package com.rtrk.netbeansllvmsdk.td.lexer;

import static com.rtrk.netbeansllvmsdk.td.jcclexer.TableGenParserConstants.*;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class TDLanguageHierarchy extends LanguageHierarchy<TDTokenId> {
    private static List<TDTokenId> tokens;
    private static Map<Integer, TDTokenId> idToToken;

    private static void init() {
        tokens = Arrays.<TDTokenId>asList(new TDTokenId[]{
            new TDTokenId("EOF", "whitespace", EOF),
            new TDTokenId("WHITESPACE", "whitespace", WHITESPACE),
            new TDTokenId("SINGLE_LINE_COMMENT", "comment", SINGLE_LINE_COMMENT),
            new TDTokenId("MULTI_LINE_COMMENT", "comment", MULTI_LINE_COMMENT),
            new TDTokenId("BIT", "keyword", BIT),
            new TDTokenId("BITS", "keyword", BITS),
            new TDTokenId("CLASS", "keyword", CLASS),
            new TDTokenId("CODE", "keyword", CODE),
            new TDTokenId("DAG", "keyword", DAG),
            new TDTokenId("DEF", "keyword", DEF),
            new TDTokenId("FOREACH", "keyword", FOREACH),
            new TDTokenId("DEFM", "keyword", DEFM),
            new TDTokenId("FIELD", "keyword", FIELD),
            new TDTokenId("IN", "keyword", IN),
            new TDTokenId("INT", "keyword", INT),
            new TDTokenId("LET", "keyword", LET),
            new TDTokenId("LIST", "keyword", LIST),
            new TDTokenId("MULTICLASS", "keyword", MULTICLASS),
            new TDTokenId("STRING", "keyword", STRING),
            new TDTokenId("INTEGER_LITERAL", "literal", INTEGER_LITERAL),
            new TDTokenId("DECIMAL_LITERAL", "literal", DECIMAL_LITERAL),
            new TDTokenId("HEX_LITERAL", "literal", HEX_LITERAL),
            new TDTokenId("OCTAL_LITERAL", "literal", OCTAL_LITERAL),
            new TDTokenId("FLOATING_POINT_LITERAL", "literal", FLOATING_POINT_LITERAL),
            new TDTokenId("DECIMAL_FLOATING_POINT_LITERAL", "literal", DECIMAL_FLOATING_POINT_LITERAL),
            new TDTokenId("DECIMAL_EXPONENT", "number", DECIMAL_EXPONENT),
            new TDTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "literal", HEXADECIMAL_FLOATING_POINT_LITERAL),
            new TDTokenId("HEXADECIMAL_EXPONENT", "number", HEXADECIMAL_EXPONENT),
            new TDTokenId("CHARACTER_LITERAL", "literal", CHARACTER_LITERAL),
            new TDTokenId("STRING_LITERAL", "literal", STRING_LITERAL),
            new TDTokenId("IDENTIFIER", "identifier", IDENTIFIER),
            new TDTokenId("LETTER", "literal", LETTER),
            new TDTokenId("PART_LETTER", "literal", PART_LETTER),
            new TDTokenId("LPAREN", "operator", LPAREN),
            new TDTokenId("RPAREN", "operator", RPAREN),
            new TDTokenId("LBRACE", "operator", LBRACE),
            new TDTokenId("RBRACE", "operator", RBRACE),
            new TDTokenId("LBRACKET", "operator", LBRACKET),
            new TDTokenId("RBRACKET", "operator", RBRACKET),
            new TDTokenId("SEMICOLON", "operator", SEMICOLON),
            new TDTokenId("COMMA", "operator", COMMA),
            new TDTokenId("DOT", "operator", DOT),
            new TDTokenId("ASSIGN", "operator", ASSIGN),
            new TDTokenId("LT", "operator", LT),
            new TDTokenId("GT", "operator", GT),
            new TDTokenId("BANG", "operator", BANG),
            new TDTokenId("HOOK", "operator", HOOK),
            new TDTokenId("COLON", "operator", COLON),
            new TDTokenId("PLUS", "operator", PLUS),
            new TDTokenId("MINUS", "operator", MINUS),
            new TDTokenId("STAR", "operator", STAR),
            new TDTokenId("SLASH", "operator", SLASH)
        });
        idToToken = new HashMap<Integer, TDTokenId>();
        for (TDTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized TDTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<TDTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<TDTokenId> createLexer(LexerRestartInfo<TDTokenId> info) {
        return new TDLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-td";
    }
}
