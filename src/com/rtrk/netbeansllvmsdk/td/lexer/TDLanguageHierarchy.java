package com.rtrk.netbeansllvmsdk.td.lexer;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class TDLanguageHierarchy extends LanguageHierarchy<TDTokenId> {
    private static List<TDTokenId> tokens;
    private static Map<Integer, TDTokenId> idToToken;

    private static void init() {
        tokens = Arrays.<TDTokenId>asList(new TDTokenId[]{
            new TDTokenId("EOF", "whitespace", 0),
            new TDTokenId("WHITESPACE", "whitespace", 1),
            new TDTokenId("SINGLE_LINE_COMMENT", "comment", 4),
            new TDTokenId("FORMAL_COMMENT", "comment", 5),
            new TDTokenId("MULTI_LINE_COMMENT", "comment", 6),
            new TDTokenId("BIT", "keyword", 12),
            new TDTokenId("BITS", "keyword", 13),
            new TDTokenId("CLASS", "keyword", 14),
            new TDTokenId("CODE", "keyword", 15),
            new TDTokenId("DAG", "keyword", 16),
            new TDTokenId("DEF", "keyword", 17),
            new TDTokenId("FOREACH", "keyword", 18),
            new TDTokenId("DEFM", "keyword", 19),
            new TDTokenId("FIELD", "keyword", 20),
            new TDTokenId("IN", "keyword", 21),
            new TDTokenId("INT", "keyword", 22),
            new TDTokenId("LET", "keyword", 23),
            new TDTokenId("LIST", "keyword", 24),
            new TDTokenId("MULTICLASS", "keyword", 25),
            new TDTokenId("STRING", "keyword", 26),
            new TDTokenId("INTEGER_LITERAL", "literal", 27),
            new TDTokenId("DECIMAL_LITERAL", "literal", 28),
            new TDTokenId("HEX_LITERAL", "literal", 29),
            new TDTokenId("OCTAL_LITERAL", "literal", 30),
            new TDTokenId("FLOATING_POINT_LITERAL", "literal", 31),
            new TDTokenId("DECIMAL_FLOATING_POINT_LITERAL", "literal", 32),
            new TDTokenId("DECIMAL_EXPONENT", "number", 33),
            new TDTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "literal", 34),
            new TDTokenId("HEXADECIMAL_EXPONENT", "number", 35),
            new TDTokenId("CHARACTER_LITERAL", "literal", 36),
            new TDTokenId("STRING_LITERAL", "literal", 37),
            new TDTokenId("IDENTIFIER", "identifier", 38),
            new TDTokenId("LETTER", "literal", 39),
            new TDTokenId("PART_LETTER", "literal", 40),
            new TDTokenId("LPAREN", "operator", 41),
            new TDTokenId("RPAREN", "operator", 42),
            new TDTokenId("LBRACE", "operator", 43),
            new TDTokenId("RBRACE", "operator", 44),
            new TDTokenId("LBRACKET", "operator", 45),
            new TDTokenId("RBRACKET", "operator", 46),
            new TDTokenId("SEMICOLON", "operator", 47),
            new TDTokenId("COMMA", "operator", 48),
            new TDTokenId("DOT", "operator", 49),
            new TDTokenId("AT", "operator", 50),
            new TDTokenId("ASSIGN", "operator", 51),
            new TDTokenId("LT", "operator", 52),
            new TDTokenId("BANG", "operator", 53),
            new TDTokenId("TILDE", "operator", 54),
            new TDTokenId("HOOK", "operator", 55),
            new TDTokenId("COLON", "operator", 56),
            new TDTokenId("EQ", "operator", 57),
            new TDTokenId("LE", "operator", 58),
            new TDTokenId("GE", "operator", 59),
            new TDTokenId("NE", "operator", 60),
            new TDTokenId("SC_OR", "operator", 61),
            new TDTokenId("SC_AND", "operator", 62),
            new TDTokenId("INCR", "operator", 63),
            new TDTokenId("DECR", "operator", 64),
            new TDTokenId("PLUS", "operator", 65),
            new TDTokenId("MINUS", "operator", 66),
            new TDTokenId("STAR", "operator", 67),
            new TDTokenId("SLASH", "operator", 68),
            new TDTokenId("BIT_AND", "operator", 69),
            new TDTokenId("BIT_OR", "operator", 70),
            new TDTokenId("XOR", "operator", 71),
            new TDTokenId("REM", "operator", 72),
            new TDTokenId("LSHIFT", "operator", 73),
            new TDTokenId("PLUSASSIGN", "operator", 74),
            new TDTokenId("MINUSASSIGN", "operator", 75),
            new TDTokenId("STARASSIGN", "operator", 76),
            new TDTokenId("SLASHASSIGN", "operator", 77),
            new TDTokenId("ANDASSIGN", "operator", 78),
            new TDTokenId("ORASSIGN", "operator", 79),
            new TDTokenId("XORASSIGN", "operator", 80),
            new TDTokenId("REMASSIGN", "operator", 81),
            new TDTokenId("LSHIFTASSIGN", "operator", 82),
            new TDTokenId("RSIGNEDSHIFTASSIGN", "operator", 83),
            new TDTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 84),
            new TDTokenId("ELLIPSIS", "operator", 85),
            new TDTokenId("RUNSIGNEDSHIFT", "operator", 86),
            new TDTokenId("RSIGNEDSHIFT", "operator", 87),
            new TDTokenId("GT", "operator", 88)
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
        return "text/x-sj";
    }
}
