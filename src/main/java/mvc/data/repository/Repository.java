package mvc.data.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import mvc.data.model.Invoices;
import mvc.data.model.QInvoces;
import mvc.data.model.QUsers;
import mvc.data.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsersJpaRepository usersRepository;

    @Autowired
    private InvocesJpaRepository invocesRepository;

    public List<Invoices> getInvocesByUser(long userId) {
        QUsers users = QUsers.users;
        QInvoces invoces = QInvoces.invoces;

        return new JPAQuery(entityManager)
                .from(invoces)
                .join(users)
                .on(invoces.userId.eq(users.id))
                .where(invoces.userId.eq(userId))
                .list(invoces);
    }

    public List<Users> getUserByInvoce(long invoiceId){
        QUsers users = QUsers.users;
        QInvoces invoces = QInvoces.invoces;

        return new JPAQuery(entityManager)
                .from(users)
                .join(invoces)
                .on(users.id.eq(invoces.userId))
                .where(invoces.id.eq(invoiceId))
                .list(users);
    }

    public Invoices getInvoceById(long id){
        return this.invocesRepository.findOne(id);
    }

    public List<Invoices> getInvoces(){
        return this.invocesRepository.findAll();
    }

    public List<Users> getUsers(){
        return this.usersRepository.findAll();
    }

    public Users getUserById(long id){
        return this.usersRepository.findOne(id);
    }

    public Users createUser(Users user){
        return this.usersRepository.save(user);
    }

    public Invoices createInvoce(Invoices invoice){
        return this.invocesRepository.save(invoice);
    }
}
