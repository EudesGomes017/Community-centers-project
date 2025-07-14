package repositories;

import models.CommunityCenter;
import models.Negotiation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RepositoryNegotiation extends MongoRepository<CommunityCenter, UUID> {


    // Buscar todas de um centro específico
    List<Negotiation> findByOriginCenterIdOrDestinationCenterId(String originId, String destinationId);

    // Buscar por centro + intervalo de tempo
    List<Negotiation> findByDateTimeBetweenAndOriginCenterIdOrDestinationCenterId(
            LocalDateTime initial,
            LocalDateTime finsh,
            String originId,
            String destinationId
    );
}
