package term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class TermList extends ArrayList<Term> {
	public TermList() {
	}

	// This constructor can take any number of Terms as arguments.
	public TermList(Term... terms) {
		super(Arrays.asList(terms));
	}

	public Set<Variable> collectVariables(Set<Variable> set) {
		for (Term term : this) {
			term.collectVariables(set);
		}
		return set;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('(');
		for (Term term : this) {
			builder.append(term).append(", ");
		}
		int length = builder.length();
		if (length > 2) {
			builder.setLength(length - 2);
		}
		builder.append(')');
		return builder.toString();
	}

	public Object substitute(Variable x, Variable y) {
		Term[] list = new Term[this.size()];
		int i = 0;
		for (Term t : this) {

			list[i] = t.substitute(x, y);
			i++;

		}

		// strs.toArray(new String[strs.size()])
		return new TermList(list);
	}
}
