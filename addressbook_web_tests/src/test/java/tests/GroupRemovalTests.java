package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    @Epic("Проверка групп")
    @DisplayName("Удаление случайной группы")
    public void canRemoveGroup() {
        Allure.step("Checking precondition", step -> {
            app.groups().createGroupIfNotExist();
        });
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Allure.step("Validating results", step -> {
            Assertions.assertEquals(newGroups, expectedList);
        });

    }

    @Test
    @Epic("Проверка групп")
    @DisplayName("Удаление всех групп")
    void canRemoveAllGroupsAtOnce() {
        app.groups().createGroupIfNotExist();
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.hbm().getGroupCount());
    }

}

