package com.tobeto.bootcampProject.business.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
public class SuccessMessages {
    public static String createSuccessMessage(String itemName) {
        return itemName + " created successfully!";
    }

    public static String listAllSuccessMessage(String itemName) {
        return "All " + itemName + " listed successfully!";
    }

    public static String listSingleSuccessMessage(String itemName) {
        return "The " + itemName + " listed successfully!";
    }

    public static String updateSuccessMessage(String itemName) {
        return "The " + itemName + " updated successfully!";
    }

    public static String sortSuccessMessage(String itemName) {
        return "All " + itemName + " sorted successfully!";
    }

    public static String deleteSuccessMessage(String itemName) {
        return "The " + itemName + " deleted successfully!";
    }

}
