package ntt.ntt_ms_creditcards.repository;

import ntt.ntt_ms_creditcards.entity.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {
}
