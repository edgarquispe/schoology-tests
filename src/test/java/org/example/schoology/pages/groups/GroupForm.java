package org.example.schoology.pages.groups;

public enum GroupForm {
    NAME("Name"),
    DESCRIPTION("Description"),
    PRIVACY("Privacy"),
    ACCESS("Access"),
    CATEGORY("Category");

    private final String name;

    GroupForm(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
