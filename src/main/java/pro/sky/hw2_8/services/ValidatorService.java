package pro.sky.hw2_8.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.hw2_8.exceptions.InvalidFirstNameException;
import pro.sky.hw2_8.exceptions.InvalidLastNameException;

@Service
public class ValidatorService {
    public String validateFirstName(String firstName) {
        firstName = StringUtils.trimToNull(firstName);
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidFirstNameException();
        }
        return StringUtils.capitalize(firstName.toLowerCase());
    }

    public String validateLastName(String lastName) {
        lastName = StringUtils.trimToNull(lastName);
        String[] names = lastName.split(" *- *");
        for (int i = 0; i < names.length; i++) {
            if (!StringUtils.isAlpha(names[i])) {
                throw new InvalidLastNameException();
            }
            names[i] = StringUtils.capitalize(names[i].toLowerCase());
        }
        return String.join("-", names);
    }
}

