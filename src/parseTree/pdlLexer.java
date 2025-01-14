// Generated from C:/Users/omerh/Desktop/GitHub/omerLanguage\pdl.g4 by ANTLR 4.9.1

package parseTree;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class pdlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		CHAR=18, COLON=19, SEMICOLON=20, LPARENS=21, RPARENS=22, QUOTE=23, COMMA=24, 
		DOT=25, LT=26, GT=27, EQUALS=28, LE=29, GE=30, NE=31, NLT=32, NGT=33, 
		ADD=34, SUB=35, MUL=36, DIV=37, MOD=38, NEWLINE=39, WS=40, QUESTION=41, 
		BANG=42, SPACE=43, SIGN=44, IDENT=45, NUMBER=46, STRING=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"CHAR", "COLON", "SEMICOLON", "LPARENS", "RPARENS", "QUOTE", "COMMA", 
			"DOT", "LT", "GT", "EQUALS", "LE", "GE", "NE", "NLT", "NGT", "ADD", "SUB", 
			"MUL", "DIV", "MOD", "NEWLINE", "WS", "QUESTION", "BANG", "SPACE", "SIGN", 
			"IDENT", "NUMBER", "DIGIT", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'global'", "'endprogram'", "'proc'", "'endproc'", 
			"'output'", "'input'", "'call'", "'set'", "'to'", "'while'", "'do'", 
			"'endwhile'", "'if'", "'then'", "'endif'", "'else'", "'[A-Za-z]'", "':'", 
			"';'", "'('", "')'", "'\"'", "','", "'.'", "'<'", "'>'", "'='", "'<='", 
			"'>='", "'!='", "'!<'", "'!>'", "'+'", "'-'", "'*'", "'/'", "'%'", null, 
			null, "'?'", "'!'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "CHAR", "COLON", "SEMICOLON", "LPARENS", 
			"RPARENS", "QUOTE", "COMMA", "DOT", "LT", "GT", "EQUALS", "LE", "GE", 
			"NE", "NLT", "NGT", "ADD", "SUB", "MUL", "DIV", "MOD", "NEWLINE", "WS", 
			"QUESTION", "BANG", "SPACE", "SIGN", "IDENT", "NUMBER", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public pdlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "pdl.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0139\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\5(\u0100\n(\3(\3(\3(\3(\3)\6)\u0107\n)\r)\16)\u0108"+
		"\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\5-\u0115\n-\3.\3.\7.\u0119\n.\f.\16.\u011c"+
		"\13.\3/\5/\u011f\n/\3/\6/\u0122\n/\r/\16/\u0123\3/\3/\7/\u0128\n/\f/\16"+
		"/\u012b\13/\5/\u012d\n/\3\60\3\60\3\61\3\61\7\61\u0133\n\61\f\61\16\61"+
		"\u0136\13\61\3\61\3\61\3\u0134\2\62\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\2a\61\3\2\6\4\2\13\13\"\"\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\2\u0140"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2a\3\2\2\2\3c\3"+
		"\2\2\2\5k\3\2\2\2\7r\3\2\2\2\t}\3\2\2\2\13\u0082\3\2\2\2\r\u008a\3\2\2"+
		"\2\17\u0091\3\2\2\2\21\u0097\3\2\2\2\23\u009c\3\2\2\2\25\u00a0\3\2\2\2"+
		"\27\u00a3\3\2\2\2\31\u00a9\3\2\2\2\33\u00ac\3\2\2\2\35\u00b5\3\2\2\2\37"+
		"\u00b8\3\2\2\2!\u00bd\3\2\2\2#\u00c3\3\2\2\2%\u00c8\3\2\2\2\'\u00d1\3"+
		"\2\2\2)\u00d3\3\2\2\2+\u00d5\3\2\2\2-\u00d7\3\2\2\2/\u00d9\3\2\2\2\61"+
		"\u00db\3\2\2\2\63\u00dd\3\2\2\2\65\u00df\3\2\2\2\67\u00e1\3\2\2\29\u00e3"+
		"\3\2\2\2;\u00e5\3\2\2\2=\u00e8\3\2\2\2?\u00eb\3\2\2\2A\u00ee\3\2\2\2C"+
		"\u00f1\3\2\2\2E\u00f4\3\2\2\2G\u00f6\3\2\2\2I\u00f8\3\2\2\2K\u00fa\3\2"+
		"\2\2M\u00fc\3\2\2\2O\u00ff\3\2\2\2Q\u0106\3\2\2\2S\u010c\3\2\2\2U\u010e"+
		"\3\2\2\2W\u0110\3\2\2\2Y\u0114\3\2\2\2[\u0116\3\2\2\2]\u011e\3\2\2\2_"+
		"\u012e\3\2\2\2a\u0130\3\2\2\2cd\7r\2\2de\7t\2\2ef\7q\2\2fg\7i\2\2gh\7"+
		"t\2\2hi\7c\2\2ij\7o\2\2j\4\3\2\2\2kl\7i\2\2lm\7n\2\2mn\7q\2\2no\7d\2\2"+
		"op\7c\2\2pq\7n\2\2q\6\3\2\2\2rs\7g\2\2st\7p\2\2tu\7f\2\2uv\7r\2\2vw\7"+
		"t\2\2wx\7q\2\2xy\7i\2\2yz\7t\2\2z{\7c\2\2{|\7o\2\2|\b\3\2\2\2}~\7r\2\2"+
		"~\177\7t\2\2\177\u0080\7q\2\2\u0080\u0081\7e\2\2\u0081\n\3\2\2\2\u0082"+
		"\u0083\7g\2\2\u0083\u0084\7p\2\2\u0084\u0085\7f\2\2\u0085\u0086\7r\2\2"+
		"\u0086\u0087\7t\2\2\u0087\u0088\7q\2\2\u0088\u0089\7e\2\2\u0089\f\3\2"+
		"\2\2\u008a\u008b\7q\2\2\u008b\u008c\7w\2\2\u008c\u008d\7v\2\2\u008d\u008e"+
		"\7r\2\2\u008e\u008f\7w\2\2\u008f\u0090\7v\2\2\u0090\16\3\2\2\2\u0091\u0092"+
		"\7k\2\2\u0092\u0093\7p\2\2\u0093\u0094\7r\2\2\u0094\u0095\7w\2\2\u0095"+
		"\u0096\7v\2\2\u0096\20\3\2\2\2\u0097\u0098\7e\2\2\u0098\u0099\7c\2\2\u0099"+
		"\u009a\7n\2\2\u009a\u009b\7n\2\2\u009b\22\3\2\2\2\u009c\u009d\7u\2\2\u009d"+
		"\u009e\7g\2\2\u009e\u009f\7v\2\2\u009f\24\3\2\2\2\u00a0\u00a1\7v\2\2\u00a1"+
		"\u00a2\7q\2\2\u00a2\26\3\2\2\2\u00a3\u00a4\7y\2\2\u00a4\u00a5\7j\2\2\u00a5"+
		"\u00a6\7k\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7g\2\2\u00a8\30\3\2\2\2\u00a9"+
		"\u00aa\7f\2\2\u00aa\u00ab\7q\2\2\u00ab\32\3\2\2\2\u00ac\u00ad\7g\2\2\u00ad"+
		"\u00ae\7p\2\2\u00ae\u00af\7f\2\2\u00af\u00b0\7y\2\2\u00b0\u00b1\7j\2\2"+
		"\u00b1\u00b2\7k\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7g\2\2\u00b4\34\3\2"+
		"\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7h\2\2\u00b7\36\3\2\2\2\u00b8\u00b9"+
		"\7v\2\2\u00b9\u00ba\7j\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7p\2\2\u00bc"+
		" \3\2\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7f\2\2\u00c0"+
		"\u00c1\7k\2\2\u00c1\u00c2\7h\2\2\u00c2\"\3\2\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7n\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7g\2\2\u00c7$\3\2\2\2\u00c8"+
		"\u00c9\7]\2\2\u00c9\u00ca\7C\2\2\u00ca\u00cb\7/\2\2\u00cb\u00cc\7\\\2"+
		"\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7/\2\2\u00ce\u00cf\7|\2\2\u00cf\u00d0"+
		"\7_\2\2\u00d0&\3\2\2\2\u00d1\u00d2\7<\2\2\u00d2(\3\2\2\2\u00d3\u00d4\7"+
		"=\2\2\u00d4*\3\2\2\2\u00d5\u00d6\7*\2\2\u00d6,\3\2\2\2\u00d7\u00d8\7+"+
		"\2\2\u00d8.\3\2\2\2\u00d9\u00da\7$\2\2\u00da\60\3\2\2\2\u00db\u00dc\7"+
		".\2\2\u00dc\62\3\2\2\2\u00dd\u00de\7\60\2\2\u00de\64\3\2\2\2\u00df\u00e0"+
		"\7>\2\2\u00e0\66\3\2\2\2\u00e1\u00e2\7@\2\2\u00e28\3\2\2\2\u00e3\u00e4"+
		"\7?\2\2\u00e4:\3\2\2\2\u00e5\u00e6\7>\2\2\u00e6\u00e7\7?\2\2\u00e7<\3"+
		"\2\2\2\u00e8\u00e9\7@\2\2\u00e9\u00ea\7?\2\2\u00ea>\3\2\2\2\u00eb\u00ec"+
		"\7#\2\2\u00ec\u00ed\7?\2\2\u00ed@\3\2\2\2\u00ee\u00ef\7#\2\2\u00ef\u00f0"+
		"\7>\2\2\u00f0B\3\2\2\2\u00f1\u00f2\7#\2\2\u00f2\u00f3\7@\2\2\u00f3D\3"+
		"\2\2\2\u00f4\u00f5\7-\2\2\u00f5F\3\2\2\2\u00f6\u00f7\7/\2\2\u00f7H\3\2"+
		"\2\2\u00f8\u00f9\7,\2\2\u00f9J\3\2\2\2\u00fa\u00fb\7\61\2\2\u00fbL\3\2"+
		"\2\2\u00fc\u00fd\7\'\2\2\u00fdN\3\2\2\2\u00fe\u0100\7\17\2\2\u00ff\u00fe"+
		"\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\f\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0104\b(\2\2\u0104P\3\2\2\2\u0105\u0107\t\2\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\u010b\b)\2\2\u010bR\3\2\2\2\u010c\u010d"+
		"\7A\2\2\u010dT\3\2\2\2\u010e\u010f\7#\2\2\u010fV\3\2\2\2\u0110\u0111\7"+
		"\"\2\2\u0111X\3\2\2\2\u0112\u0115\5E#\2\u0113\u0115\5G$\2\u0114\u0112"+
		"\3\2\2\2\u0114\u0113\3\2\2\2\u0115Z\3\2\2\2\u0116\u011a\t\3\2\2\u0117"+
		"\u0119\t\4\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2"+
		"\2\2\u011a\u011b\3\2\2\2\u011b\\\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011f"+
		"\5Y-\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\u0122\5_\60\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124\u012c\3\2\2\2\u0125\u0129\7\60\2\2\u0126"+
		"\u0128\5_\60\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u0125\3\2\2\2\u012c\u012d\3\2\2\2\u012d^\3\2\2\2\u012e\u012f\t\5\2\2"+
		"\u012f`\3\2\2\2\u0130\u0134\5/\30\2\u0131\u0133\13\2\2\2\u0132\u0131\3"+
		"\2\2\2\u0133\u0136\3\2\2\2\u0134\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135"+
		"\u0137\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\5/\30\2\u0138b\3\2\2\2"+
		"\f\2\u00ff\u0108\u0114\u011a\u011e\u0123\u0129\u012c\u0134\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}