package rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.beans;

import rs.ac.uns.pmf.dmi.oop2.teamD.phoneWorld.server.entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

/**
 * Local bean that fills the database at startup
 */
@Singleton
@LocalBean
@Startup
public class FillPhoneWorldDb {

    @PersistenceContext(name = "PhoneWorldPersistence")
    private EntityManager em;

    @EJB(beanName = "PhoneWorldRepository")
    private IPhoneWorldRepository repository;

    @PostConstruct
    public void postConstruct() {

        PhoneTeam5 p1 = repository.addPhone("Nokia", "3310","20*70*40", "1 inch","480*480 p", "quad-core",2300, null /* default */);
        PhoneTeam5 p2 = repository.addPhone("Nokia", "3210","20*75*40", "1.1 inch","480*480 p", "dual-core",2350, null /* default */);

        UserTeam5 u1 = repository.addUser("Nokia lover", "Pera", "Peric", "peraperic@gmail.com", "1234pass", null /* default */, "i love nokias");
        UserTeam5 u2 = repository.addUser("Nokia hater", "Mika", "Mikic", "mikamikic@gmail.com", "12345pass", null /* default */, "i hate nokias");

        AdTeam5 a1 = repository.addAd(u1, p1, "selling nokia 3310", "awesome phone", StatusTeam5.ACTIVE, Timestamp.valueOf("2016-09-23 11:10:10.0"));
        AdTeam5 a2 = repository.addAd(u2, p2, "selling nokia 3210", "bad phone", StatusTeam5.ACTIVE, Timestamp.valueOf("2016-09-22 10:16:10.0"));

        BidTeam5 b1 = repository.addBid(a2,u1,1000);

        u1.getBids().add(b1);
        a2.getBids().add(b1);

        CommentTeam5 c1 = repository.addComment("nokia is bad", u2, a1, Timestamp.valueOf("2016-09-24 10:10:10.0"));
        CommentTeam5 c2 = repository.addComment("nokia is super cool", u1, a2, Timestamp.valueOf("2016-09-23 10:12:10.0"));

        u2.getComments().add(c1);
        a1.getComments().add(c1);
        u1.getComments().add(c2);
        a2.getComments().add(c2);

        em.merge(p1);
        em.merge(p2);
        em.merge(u1);
        em.merge(u2);
        em.merge(a1);
        em.merge(a2);
        em.merge(b1);
        em.merge(c1);
        em.merge(c2);
    }


}