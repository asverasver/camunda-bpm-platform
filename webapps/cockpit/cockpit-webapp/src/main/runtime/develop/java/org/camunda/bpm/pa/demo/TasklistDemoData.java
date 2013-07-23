package org.camunda.bpm.pa.demo;

import java.util.logging.Logger;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;

/**
 * @author: drobisch
 */
public class TasklistDemoData {

    private final static Logger LOGGER = Logger.getLogger(TasklistDemoData.class.getName());

    public void createDemoData(ProcessEngine engine) {

      User singleResult = engine.getIdentityService().createUserQuery().userId("demo").singleResult();
      if(singleResult != null) {
        return;
      }

      LOGGER.info("Generating demo data for tasklist");

      User user = engine.getIdentityService().newUser("demo");
      user.setFirstName("Demo");
      user.setLastName("Demo");
      user.setPassword("demo");
      user.setEmail("demo@camunda.org");
      engine.getIdentityService().saveUser(user);

      User user2 = engine.getIdentityService().newUser("john");
      user2.setFirstName("John");
      user2.setLastName("Doe");
      user2.setPassword("john");
      user2.setEmail("john@camunda.org");

      engine.getIdentityService().saveUser(user2);

      User user3 = engine.getIdentityService().newUser("mary");
      user3.setFirstName("Mary");
      user3.setLastName("Anne");
      user3.setPassword("mary");
      user3.setEmail("mary@camunda.org");

      engine.getIdentityService().saveUser(user3);

      User user4 = engine.getIdentityService().newUser("peter");
      user4.setFirstName("Peter");
      user4.setLastName("Meter");
      user4.setPassword("peter");
      user4.setEmail("peter@camunda.org");

      engine.getIdentityService().saveUser(user4);

      Group salesGroup = engine.getIdentityService().newGroup("sales");
      salesGroup.setName("Sales");
      salesGroup.setType("WORKFLOW");
      engine.getIdentityService().saveGroup(salesGroup);

      Group accountingGroup = engine.getIdentityService().newGroup("accounting");
      accountingGroup.setName("Accounting");
      accountingGroup.setType("WORKFLOW");
      engine.getIdentityService().saveGroup(accountingGroup);

      Group managementGroup = engine.getIdentityService().newGroup("management");
      managementGroup.setName("Management");
      managementGroup.setType("WORKFLOW");
      engine.getIdentityService().saveGroup(managementGroup);

      engine.getIdentityService().createMembership("demo", "sales");
      engine.getIdentityService().createMembership("demo", "accounting");
      engine.getIdentityService().createMembership("demo", "management");

      engine.getIdentityService().createMembership("john", "sales");
      engine.getIdentityService().createMembership("mary", "accounting");
      engine.getIdentityService().createMembership("peter", "management");
    }
}
