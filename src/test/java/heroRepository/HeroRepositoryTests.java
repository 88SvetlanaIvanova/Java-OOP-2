package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private HeroRepository heroRepository;
    private Hero hero;
    @Before
    public void setUp(){
        this.heroRepository = new HeroRepository();
        this.hero= new Hero("Desi", 2);
    }
    //1
    @Test(expected = NullPointerException.class)
    public  void testNameNull(){
        this.heroRepository.create(null);
    }
    //2
    @Test(expected = IllegalArgumentException.class)
    public  void testNameDupl(){
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);
    }
    //3
    @Test
    public  void testNameCreated(){
        Assert.assertEquals(0, this.heroRepository.getCount());

        this.heroRepository.create(this.hero);
        Hero createdHero = this.heroRepository.getHero("Desi");
        //check
        Assert.assertEquals(createdHero.getName(), this.hero.getName());
        Assert.assertEquals(createdHero.getLevel(), this.hero.getLevel());
    }
    //4
    @Test(expected = NullPointerException.class)
    public  void testRemoveNull(){
        this.heroRepository.remove(null);
    }
    //5
    @Test(expected = NullPointerException.class)
    public  void testRemoveEmptyName(){
        this.heroRepository.remove(null);
    }
    //6
    @Test
    public void testRemovalDone(){
        Assert.assertEquals(0, this.heroRepository.getCount());
        this.heroRepository.create(this.hero);
        Assert.assertEquals(1, this.heroRepository.getCount());
        this.heroRepository.remove("Desi");

        Assert.assertEquals(0, this.heroRepository.getCount());
        Hero removedHero = this.heroRepository.getHero("Desi");//null
        Assert.assertNull(removedHero);
    }
    //7
    @Test
    public void testGetHeroWithHighestLevel(){
        Hero hero1 = new Hero("Zizi", 3);
        Hero hero2 = new Hero("Buba", 6);
        Hero hero3 = new Hero("Issi", 4);
        this.heroRepository.create(hero1);
        this.heroRepository.create(hero2);
        this.heroRepository.create(hero3);

        Assert.assertEquals(3, this.heroRepository.getHeroes().size());
        Hero highestHero = this.heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(highestHero.getName(), hero2.getName());
        Assert.assertEquals(highestHero.getLevel(), hero2.getLevel());
    }
}
