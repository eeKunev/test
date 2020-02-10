package fmi.informatics.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fmi.informatics.comparators.Age1Comparator;
import fmi.informatics.comparators.AgeComparator;
import fmi.informatics.comparators.Egn1Comparator;
import fmi.informatics.comparators.EgnComparator;
import fmi.informatics.comparators.Grade1Comparator;
import fmi.informatics.comparators.GradeComparator;
import fmi.informatics.comparators.Height1Comparator;
import fmi.informatics.comparators.HeightComparator;
import fmi.informatics.comparators.Name1Comparator;
import fmi.informatics.comparators.NameComparator;
import fmi.informatics.comparators.PersonComparator;
import fmi.informatics.comparators.Weight1Comparator;
import fmi.informatics.comparators.WeightComparator;
import fmi.informatics.extending.Person;
import fmi.informatics.extending.Professor;
import fmi.informatics.extending.Student;

// създаваме клас PersonDataGUI
public class PersonDataGUI {
	
	public static Person[] people;
	JTable table;
	PersonDataModel personDataModel;

	public static void main(String[] args) {
		getPeople();
		PersonDataGUI gui = new PersonDataGUI();
		gui.createAndShowGUI();
	}
	
	public static void getPeople() {
		people = new Person[8];
		
		for (int i = 0; i < 4; i++) {
			Person student = Student.StudentGenerator.make();
			people[i] = student;
		}
		
		for (int i = 4; i < 8; i++) {
			Person professor = Professor.ProfessorGenerator.make();
			people[i] = professor;
		}
	}
	
	public void createAndShowGUI() {
		JFrame frame = new JFrame("Таблица с данни за хора");
		frame.setSize(500, 500);
		
		JLabel label = new JLabel("Списък с потребители", JLabel.CENTER);
		
		personDataModel = new PersonDataModel(people);
		table = new JTable(personDataModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		// Добавяме бутон за сортиране по години с Comparable interface
		JButton buttonSortAge = new JButton("Сортирай по години");

		// Добавяме бутон за сортиране
		JButton buttonSort = new JButton("Сортирай");
		
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(label, BorderLayout.NORTH);
		container.add(scrollPane, BorderLayout.CENTER);
		
		container.add(buttonSortAge, BorderLayout.BEFORE_FIRST_LINE);
		container.add(buttonSort, BorderLayout.SOUTH);
		
		// Добавяме listener към бутона за сортиране по години
		buttonSortAge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Arrays.sort(people);
				table.repaint();
			}
		});
		
		// Добавяме диалог
		final JDialog sortDialog = new CustomDialog(getSortText(), this);
		
		// Добавяме listener към бутона за сортиране
		buttonSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sortDialog.pack();
				sortDialog.setVisible(true);
			}
		});
		
		frame.setVisible(true);
	}
	
	public void sortTable(int intValue, JTable table, Person[] people) {
		PersonComparator comparator = null;
		
		switch (intValue) {
			case 1: 
				comparator = new NameComparator(); 
				break;
			case 2: 
				comparator = new EgnComparator();
				break;
			case 3:
				comparator = new HeightComparator();
				break;
			case 4: 
				comparator = new WeightComparator();
				break;
			case 5:
				comparator = new AgeComparator();
				break;
			case 6:
				comparator = new GradeComparator();
				break;
			case 7: 
				comparator = new Name1Comparator(); 
				break;
			case 8: 
				comparator = new Egn1Comparator();
				break;
			case 9:
				comparator = new Height1Comparator();
				break;
			case 10: 
				comparator = new Weight1Comparator();
				break;
			case 11:
				comparator = new Age1Comparator();
				break;
			case 12:
				comparator = new Grade1Comparator();
				break;
		}

		if (comparator == null) { // Ако стойността е null - сортирай по подразбиране
			Arrays.sort(people); // Сортировка по подразбиране по години
		} else {
			Arrays.sort(people, comparator);
		}
		
		table.repaint();	
	}
	
	private static String getSortText() {
		return "Моля, въведете цифрата от колоните, по която да се сортират данните: \n" +
				" 1 - Име(възходящо) "       + " 7 - Име(низходящо) \n"+
				" 2 - ЕГН(възходящо) "       + " 8 - ЕГН(низходящо) \n"+
				" 3 - Височина(възходящо) "  + " 9 - Височина(низходящо) \n"+
				" 4 - Тегло(възходящо) "     + " 10 - Тегло(низходящо) \n"+
				" 5 - Години(възходящо) "    + " 11 - Години(низходящо) \n"+
				" 6 - Успех(възходящо) "     + " 12 - Успех(низходящо) \n"; 
	}
}
