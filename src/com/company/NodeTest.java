package com.company;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void Node_GetNode_ShouldReturnData() {

        //Arrange
        Title title = Title.CEO;
        String name = "Julie Herschberger";

        //Act
        Node<Employee> node = new Node<Employee>(new Employee(Title.CEO, name));

        //Assert
        Assert.assertEquals(title, node.getNode().getTitle());
        Assert.assertEquals(name, node.getNode().getFullName());
    }

    @Test
    public void Node_AddChild_ShouldAddChildAndSetParent() {

        //Arrange
        Node<Employee> ceo = new Node<Employee>(new Employee(Title.CEO, "Julie Herschberger"));
        Node<Employee> svp = new Node<Employee>(new Employee(Title.SVP, "Amira Hail"));

        //Act
        ceo.addChild(svp);

        //Assert
        Assert.assertTrue(ceo.getChildren().contains(svp));
        Assert.assertEquals(ceo, svp.getParent());
    }

    @Test
    public void Node_SetParent_ShouldAddChildAndSetParent() {

        //Arrange
        Node<Employee> ceo = new Node<Employee>(new Employee(Title.CEO, "Julie Herschberger"));
        Node<Employee> svp = new Node<Employee>(new Employee(Title.SVP, "Amira Hail"));

        //Act
        svp.setParent(ceo);

        //Assert
        Assert.assertTrue(ceo.getChildren().contains(svp));
        Assert.assertEquals(ceo, svp.getParent());
    }

    @Test
    public void Node_GetChildren_ShouldContainOneChild() {

        //Arrange
        Node<Employee> ceo = new Node<Employee>(new Employee(Title.CEO, "Julie Herschberger"));
        Node<Employee> svp = new Node<Employee>(new Employee(Title.SVP, "Amira Hail"));
        Node<Employee> vp = new Node<Employee>(new Employee(Title.VP, "Jose Thomson"));

        //Act
        ceo.addChild(svp);
        svp.addChild(vp);

        //Assert
        Assert.assertEquals(1, ceo.getChildren(2).size());
    }

    @Test
    public void Node_GetChildren_ShouldContainTwoVPs() {

        //Arrange
        Node<Employee> ceo = new Node<Employee>(new Employee(Title.CEO, "Julie Herschberger"));
        Node<Employee> svp = new Node<Employee>(new Employee(Title.SVP, "Amira Hail"));
        Node<Employee> vp1 = new Node<Employee>(new Employee(Title.VP, "Jose Thomson"));
        Node<Employee> vp2 = new Node<Employee>(new Employee(Title.VP, "Eric Webb"));

        //Act
        ceo.addChild(svp);
        svp.addChild(vp1);
        svp.addChild(vp2);

        //Assert
        Assert.assertEquals(2, ceo.getChildren(2).size());
    }

    @Test
    public void Node_GetChildren_ShouldContainThreeVPs() {

        //Arrange
        Node<Employee> ceo = new Node<Employee>(new Employee(Title.CEO, "Julie Herschberger"));
        Node<Employee> svp1 = new Node<Employee>(new Employee(Title.SVP, "Amira Hail"));
        Node<Employee> svp2 = new Node<Employee>(new Employee(Title.SVP, "Max Weston"));
        Node<Employee> vp1 = new Node<Employee>(new Employee(Title.VP, "Jose Thomson"));
        Node<Employee> vp2 = new Node<Employee>(new Employee(Title.VP, "Eric Webb"));
        Node<Employee> vp3 = new Node<Employee>(new Employee(Title.VP, "Teresa Sadler"));

        //Act
        ceo.addChild(svp1);
        ceo.addChild(svp2);
        svp1.addChild(vp1);
        svp1.addChild(vp2);
        svp2.addChild(vp3);

        //Assert
        Assert.assertEquals(3, ceo.getChildren(2).size());
    }

    @Test
    public void Node_GetChildrenMultipleLevels_ShouldContainAppropriateNumberOfEmployees() {

        //Arrange
        Node<Employee> ceo = new Node<Employee>(new Employee(Title.CEO, "ceo"));
        Node<Employee> svp1 = new Node<Employee>(new Employee(Title.SVP, "svp1"));
        Node<Employee> svp2 = new Node<Employee>(new Employee(Title.SVP, "svp2"));
        Node<Employee> vp1 = new Node<Employee>(new Employee(Title.VP, "vp1"));
        Node<Employee> vp2 = new Node<Employee>(new Employee(Title.VP, "vp2"));
        Node<Employee> vp3 = new Node<Employee>(new Employee(Title.VP, "vp3"));
        Node<Employee> d1 = new Node<Employee>(new Employee(Title.Director, "D1"));
        Node<Employee> m1 = new Node<Employee>(new Employee(Title.Manager, "M1"));
        Node<Employee> m2 = new Node<Employee>(new Employee(Title.Manager, "M2"));
        Node<Employee> m3 = new Node<Employee>(new Employee(Title.Manager, "M3"));
        Node<Employee> m4 = new Node<Employee>(new Employee(Title.Manager, "M4"));
        Node<Employee> m5 = new Node<Employee>(new Employee(Title.Manager, "M5"));
        Node<Employee> i1 = new Node<Employee>(new Employee(Title.IndividualContributor, "I1"));
        Node<Employee> i2 = new Node<Employee>(new Employee(Title.IndividualContributor, "I2"));
        Node<Employee> i3 = new Node<Employee>(new Employee(Title.IndividualContributor, "I3"));
        Node<Employee> i4 = new Node<Employee>(new Employee(Title.IndividualContributor, "I4"));
        Node<Employee> i5 = new Node<Employee>(new Employee(Title.IndividualContributor, "I5"));
        Node<Employee> i6 = new Node<Employee>(new Employee(Title.IndividualContributor, "I6"));
        Node<Employee> i7 = new Node<Employee>(new Employee(Title.IndividualContributor, "I7"));

        //Act
        ceo.addChild(svp1);
        ceo.addChild(vp1);
        ceo.addChild(svp2);
        ceo.addChild(vp2);
        vp1.addChild(d1);
        vp1.addChild(m1);
        vp1.addChild(i1);
        svp2.addChild(vp3);
        vp2.addChild(i2);
        vp2.addChild(m2);
        d1.addChild(m3);
        vp3.addChild(m4);
        vp3.addChild(m5);
        m2.addChild(i3);
        m2.addChild(i4);
        m2.addChild(i5);
        m3.addChild(i6);
        m5.addChild(i7);

        //Assert
        Assert.assertEquals(0, ceo.getChildren(-1).size());
        Assert.assertEquals(1, ceo.getChildren(0).size());
        Assert.assertEquals(4, ceo.getChildren(1).size());
        Assert.assertEquals(6, ceo.getChildren(2).size());
        Assert.assertEquals(6, ceo.getChildren(3).size());
        Assert.assertEquals(2, ceo.getChildren(4).size());
        Assert.assertEquals(0, ceo.getChildren(5).size());
        Assert.assertEquals(0, ceo.getChildren(6).size());
    }
}