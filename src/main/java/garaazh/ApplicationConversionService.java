package garaazh;

import garaazh.converters.TarnijaConverter;
import garaazh.converters.TootjaConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.stereotype.Component;

/**
 * Created by kaarel on 25/04/15.
 */
@Component("mvcConversionService")
public class ApplicationConversionService extends DefaultFormattingConversionService {

    public ApplicationConversionService() {
        super();

        addConverter(new TootjaConverter());
        addConverter(new TarnijaConverter());
    }
}
