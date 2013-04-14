package project.gui.util;

import javax.swing.*;
import java.math.BigDecimal;
import java.text.ParseException;

public final class DollarAmountFormatter extends JFormattedTextField.AbstractFormatter {
    public static final class Factory extends JFormattedTextField.AbstractFormatterFactory {
        private final boolean acceptsNull;

        public Factory() {
            this(false);
        }

        public Factory(boolean acceptsNull) {
            this.acceptsNull = acceptsNull;
        }

        @Override
        public DollarAmountFormatter getFormatter(JFormattedTextField tf) {
            return new DollarAmountFormatter(acceptsNull);
        }
    }

    private final boolean acceptsNull;

    public DollarAmountFormatter() {
        this(false);
    }

    public DollarAmountFormatter(boolean acceptsNull) {
        this.acceptsNull = acceptsNull;
    }

    @Override
    public Object stringToValue(String text) throws ParseException {
        if (acceptsNull && (text == null || text.isEmpty())) {
            return null;
        } else {
            try {
                return new BigDecimal(text);
            } catch (NumberFormatException nfx) {
                throw new ParseException(nfx.getMessage(), 0);
            }
        }
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (acceptsNull && value == null) {
            return "";
        } else if (value instanceof BigDecimal) {
            return String.format("%.2f", value);
        } else {
            throw new ParseException("value is not a BigDecimal", 0);
        }
    }
}
