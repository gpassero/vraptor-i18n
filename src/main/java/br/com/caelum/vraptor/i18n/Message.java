package br.com.caelum.vraptor.i18n;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class Message {

	private static final String[] ZERO = { "0" };
	private static final String[] ONE = { "1" };
	private String key;
	private String[] args;
	private final ResourceBundle bundle;

	public Message(ResourceBundle bundle, String key) {
		this.bundle = bundle;
		this.key = key;
	}

	public Message count(int count) {
		if (count == 0) {
			key += ".zero";
			args = ZERO;
		} else if (count == 1) {
			key += ".one";
			args = ONE;
		} else {
			key += ".other";
			args = new String[] { "" + count };
		}
		return this;
	}

	public Message args(String[] parameters) {
		if (this.args == null) {
			this.args = parameters;
			return this;
		}
		int pos = args.length;
		this.args = Arrays.copyOf(this.args, this.args.length
				+ parameters.length);
		for (String parameter : parameters) {
			this.args[pos++] = parameter;
		}
		return this;
	}

	public Message args(String parameter) {
		String[] parameters = { parameter };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2) {
		String[] parameters = { parameter1, parameter2 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3) {
		String[] parameters = { parameter1, parameter2, parameter3 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3, String parameter4) {
		String[] parameters = { parameter1, parameter2, parameter3, parameter4 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3, String parameter4, String parameter5) {
		String[] parameters = { parameter1, parameter2, parameter3, parameter4, parameter5 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3, String parameter4, String parameter5,
			String parameter6) {
		String[] parameters = { parameter1, parameter2, parameter3, parameter4, parameter5, parameter6 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3, String parameter4, String parameter5,
			String parameter6, String parameter7) {
		String[] parameters = { parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3, String parameter4, String parameter5,
			String parameter6, String parameter7, String parameter8) {
		String[] parameters = { parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7,
				parameter8 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3, String parameter4, String parameter5,
			String parameter6, String parameter7, String parameter8, String parameter9) {
		String[] parameters = { parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7,
				parameter8, parameter9 };
		return this.args(parameters);
	}

	public Message args(String parameter1, String parameter2, String parameter3, String parameter4, String parameter5,
			String parameter6, String parameter7, String parameter8, String parameter9, String parameter10) {
		String[] parameters = { parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7,
				parameter8, parameter9, parameter10 };
		return this.args(parameters);
	}

	private String getValue() {
		String message = bundle.getString(key);
		if (message.equals("???" + key + "???")) {
			return "<span class='i18n_missing_key'>" + key + "</span>";
		}
		if (this.args == null) {
			return message;
		}
		for (int i = 0; i < args.length; i++) {
			if (bundle.containsKey(args[i])) {
				args[i] = bundle.getString(args[i]);
			}
		}
		return MessageFormat.format(message, (Object[])args);
	}

	@Override
	public String toString() {
		return getValue();
	}

}
