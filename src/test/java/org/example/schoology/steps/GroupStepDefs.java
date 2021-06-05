package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import org.testng.asserts.Assertion;

import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.schoology.hooks.GroupHooks;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.groups.CreateGroupPopup;
import org.example.schoology.pages.groups.EditGroupPopup;
import org.example.schoology.pages.groups.GroupForm;
import org.example.schoology.pages.groups.Groups;

public class GroupStepDefs {

    private final ScenarioContext context;

    private Groups groups;

    private final Assertion assertion;

    public GroupStepDefs(final AssertionGroup assertionGroup, final ScenarioContext context, final Groups groups) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.groups = groups;
    }

    @And("I create a group with:")
    public void iCreateAGroupWith(final Map<GroupForm, String> datatable) {
        String menu = "Groups";
        SubMenu subMenu = new Home().clickMenu(menu);
        subMenu.clickViewListLink(menu);
        CreateGroupPopup createGroupPopup = this.groups.clickCreateGroupButton();
        createGroupPopup.create(datatable);
        context.setContext(GroupHooks.GROUP_KEY, datatable.get(GroupForm.NAME));
    }

    @And("I edit the {string} group with:")
    public void iEditTheGroupWith(final String name, final Map<GroupForm, String> datatable) {
        EditGroupPopup editGroupPopup = groups.clickEditGroup(name);
        groups = editGroupPopup.edit(datatable);
        context.setContext(GroupHooks.GROUP_KEY, datatable.get(GroupForm.NAME));
    }

    @And("I should see a group with {string} as a name")
    public void iShouldSeeAGroupWithAsName(final String groupName) {
        assertion.assertEquals(groupName, groups.getGroupByName(groupName));
    }

}
