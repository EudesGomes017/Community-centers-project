package repositories;

import models.CommunityCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CommunityCenterRepository extends MongoRepository<CommunityCenter, UUID> {
}
