package edu.odu.cs.cs350;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class TestMagazine {

	//due to all know laws of aviation
	
	@Test
	public void testDeafultConstructor() {
		Magazine m = new Magazine();
		LocalDate localDateNow = LocalDate.now();
		String title = "";
		assertTrue(m.getTitle().equals(title));
		assertEquals(m.getPublicationDate(),localDateNow);
		assertEquals(m.numArticles(),0);
		assertTrue(m.startingPages().isEmpty());
	}

	@Test
	public void testConstructor() {
		
		LocalDate localD = LocalDate.of(1999,9,21);
		String title = "That time a meme was born";
		Magazine m = new Magazine("That time a meme was born",localD);
		
		assertTrue(m.getTitle().equals(title));
		assertTrue(m.getPublicationDate().equals(localD));
		assertEquals(m.numArticles(),0);
		assertTrue(m.startingPages().isEmpty());
	}
	@Test
	public void testGetTitle() {
		LocalDate localD = LocalDate.of(1999,9,21);
		String title = "That time a meme was born";
		Magazine m = new Magazine(title,localD);
		
		assertTrue(m.getTitle().equals(title));
		
		
	}
	
	@Test
	public void testSetTitle() {
		String title = "Why the Vine Sound effect is the best";
		Magazine m = new Magazine();
		m.setTitle(title);
		assertTrue(m.getTitle().equals(title));
	}
	
	@Test
	public void testGetPubDate() {
		LocalDate localD = LocalDate.of(1999,9,21);
		String title = "That time a meme was born";
		Magazine m = new Magazine(title,localD);
		
		assertTrue(m.getPublicationDate().equals(localD));
	}
	
	@Test
	public void testSetPubDate() {
		LocalDate localD = LocalDate.of(1978,9,21);
		Magazine m = new Magazine();
		m.setPublicationDate(localD);
		assertTrue(m.getPublicationDate().equals(localD));
	}
	
	@Test
	public void testAddArtic() {
		Article a = new Article("Why do bees sting?","Joe Jonas");
		Article b = new Article("Does my breath stink?","Nick Jonas");
		Article c = new Article("How I beat my brothers!","Kevin Jonas");
		
		Magazine m = new Magazine();
		
		m.addArticle(3, a);
		assertEquals(m.numArticles(),1);
		assertEquals(m.startingPages().size(),1);
		assertTrue(m.getArticle(3).equals(a));
		
		m.addArticle(6, b);
		assertEquals(m.numArticles(),2);
		assertEquals(m.startingPages().size(),2);
		assertTrue(m.getArticle(6).equals(b));
		
		m.addArticle(3, c);
		assertEquals(m.numArticles(),2);
		assertEquals(m.startingPages().size(),2);
		assertTrue(m.getArticle(3).equals(c));
		
		m.addArticle(9, a);
		assertEquals(m.numArticles(),3);
		assertEquals(m.startingPages().size(),3);
		assertTrue(m.getArticle(9).equals(a));
		
	}
	
	@Test
	public void testGetArtic() {
		Article a = new Article("Why do bees sting?","Joe Jonas");
		Magazine m = new Magazine();
		
		m.addArticle(3, a);
		assertTrue(m.getArticle(3).equals(a));
		assertNull(m.getArticle(100));
		
	}
	
	@Test
	public void testClone() {
		LocalDate localD = LocalDate.of(1999,9,21);
		String title = "That time a meme was born";
		Magazine m = new Magazine(title,localD);
		Magazine clone;
		
		Article a = new Article("Why do bees sting?","Joe Jonas");
		Article b = new Article("Does my breath stink?","Nick Jonas");
		Article c = new Article("How I beat my brothers!","Kevin Jonas");
		
		m.addArticle(3, a);
		m.addArticle(6, b);
		m.addArticle(9, c);
		
		clone = (Magazine) m.clone();
		
		assertTrue(m.getTitle().equals(clone.getTitle()));
		assertTrue(m.getPublicationDate().equals(clone.getPublicationDate()));
		assertEquals(m.numArticles(),clone.numArticles());
		assertTrue(m.getArticle(3).equals(clone.getArticle(3)));
		assertTrue(m.getArticle(6).equals(clone.getArticle(6)));
		assertTrue(m.getArticle(9).equals(clone.getArticle(9)));
		
		
		
	}
	
	@Test
	public void testArtNum() {
		Article a = new Article("Why do bees sting?","Joe Jonas");
		
		Magazine m = new Magazine();
		m.addArticle(1, a);
		m.addArticle(2, a);
		m.addArticle(3, a);
		m.addArticle(4, a);
		
		assertEquals(m.numArticles(),4);
		
	}
	
	
	
	
}