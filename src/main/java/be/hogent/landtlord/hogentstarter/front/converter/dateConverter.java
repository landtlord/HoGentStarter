package be.hogent.landtlord.hogentstarter.front.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@FacesConverter("dateConverter")
public class dateConverter extends DateTimeConverter {
    public dateConverter() {
        setPattern("yyyy-MM-dd");
    }

    @Override
    public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() != getPattern().length()) {
            throw new ConverterException("Invalid format");
        }

        Date asObject = (Date) super.getAsObject(context, component, value);
        return asObject.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


}
