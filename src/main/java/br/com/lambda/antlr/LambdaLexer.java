// Generated from Lambda.g4 by ANTLR 4.7.1
package br.com.lambda.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LambdaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RPAR=2, LPAR=3, RCURL=4, LCURL=5, PLUS=6, MINUS=7, MULT=8, DIV=9, 
		DOT=10, EQ=11, NEQ=12, GT=13, LT=14, GTEQ=15, LTEQ=16, IF=17, THEN=18, 
		ELSE=19, REC=20, INT=21, VAR=22, LAMBDA=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "RPAR", "LPAR", "RCURL", "LCURL", "PLUS", "MINUS", "MULT", "DIV", 
		"DOT", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "IF", "THEN", "ELSE", 
		"REC", "INT", "VAR", "LAMBDA", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "' '", "')'", "'('", "'}'", "'{'", "'+'", "'-'", "'*'", "'/'", "'.'", 
		"'='", "'!='", "'>'", "'<'", "'>='", "'<='", "'if'", "'then'", "'else'", 
		"'rec'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "RPAR", "LPAR", "RCURL", "LCURL", "PLUS", "MINUS", "MULT", 
		"DIV", "DOT", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "IF", "THEN", "ELSE", 
		"REC", "INT", "VAR", "LAMBDA", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LambdaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lambda.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\26\6\26i\n\26\r\26\16\26j\3\27\3\27\7\27"+
		"o\n\27\f\27\16\27r\13\27\3\30\3\30\3\31\6\31w\n\31\r\31\16\31x\3\31\3"+
		"\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\7\3\2\62;\4"+
		"\2C\\c|\5\2\62;C\\c|\4\2^^\u03bd\u03bd\4\2\13\f\"\"\2~\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3"+
		"\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2\2\2\13;\3\2\2\2\r=\3\2\2"+
		"\2\17?\3\2\2\2\21A\3\2\2\2\23C\3\2\2\2\25E\3\2\2\2\27G\3\2\2\2\31I\3\2"+
		"\2\2\33L\3\2\2\2\35N\3\2\2\2\37P\3\2\2\2!S\3\2\2\2#V\3\2\2\2%Y\3\2\2\2"+
		"\'^\3\2\2\2)c\3\2\2\2+h\3\2\2\2-l\3\2\2\2/s\3\2\2\2\61v\3\2\2\2\63\64"+
		"\7\"\2\2\64\4\3\2\2\2\65\66\7+\2\2\66\6\3\2\2\2\678\7*\2\28\b\3\2\2\2"+
		"9:\7\177\2\2:\n\3\2\2\2;<\7}\2\2<\f\3\2\2\2=>\7-\2\2>\16\3\2\2\2?@\7/"+
		"\2\2@\20\3\2\2\2AB\7,\2\2B\22\3\2\2\2CD\7\61\2\2D\24\3\2\2\2EF\7\60\2"+
		"\2F\26\3\2\2\2GH\7?\2\2H\30\3\2\2\2IJ\7#\2\2JK\7?\2\2K\32\3\2\2\2LM\7"+
		"@\2\2M\34\3\2\2\2NO\7>\2\2O\36\3\2\2\2PQ\7@\2\2QR\7?\2\2R \3\2\2\2ST\7"+
		">\2\2TU\7?\2\2U\"\3\2\2\2VW\7k\2\2WX\7h\2\2X$\3\2\2\2YZ\7v\2\2Z[\7j\2"+
		"\2[\\\7g\2\2\\]\7p\2\2]&\3\2\2\2^_\7g\2\2_`\7n\2\2`a\7u\2\2ab\7g\2\2b"+
		"(\3\2\2\2cd\7t\2\2de\7g\2\2ef\7e\2\2f*\3\2\2\2gi\t\2\2\2hg\3\2\2\2ij\3"+
		"\2\2\2jh\3\2\2\2jk\3\2\2\2k,\3\2\2\2lp\t\3\2\2mo\t\4\2\2nm\3\2\2\2or\3"+
		"\2\2\2pn\3\2\2\2pq\3\2\2\2q.\3\2\2\2rp\3\2\2\2st\t\5\2\2t\60\3\2\2\2u"+
		"w\t\6\2\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\b\31\2\2"+
		"{\62\3\2\2\2\6\2jpx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}