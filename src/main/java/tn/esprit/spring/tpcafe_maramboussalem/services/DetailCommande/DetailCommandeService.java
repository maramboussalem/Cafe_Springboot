package tn.esprit.spring.tpcafe_maramboussalem.services.DetailCommande;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.DetailCommandeMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ArticleRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CommandeRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.DetailCommandeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DetailCommandeService implements IDetailCommandeService {

    DetailCommandeRepository detailCommandeRepository;
    DetailCommandeMapper detailCommandeMapper;

    @Override
    public DetailCommandeResponse addDetailCommande(DetailCommandeRequest request) {
        DetailCommande detailCommande = detailCommandeMapper.toEntity(request);
        detailCommandeRepository.save(detailCommande);
        return detailCommandeMapper.toDto(detailCommande);
    }

    @Override
    public DetailCommandeResponse selectDetailCommandeById(long id) {
        DetailCommande detail = detailCommandeRepository.findById(id).get();
        return detailCommandeMapper.toDto(detail);
    }

    @Override
    public List<DetailCommandeResponse> selectAllDetailCommande() {
        return detailCommandeRepository.findAll()
                .stream()
                .map(detailCommandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DetailCommandeResponse updateDetailCommande(long id, DetailCommandeRequest request) {
        DetailCommande detail = detailCommandeRepository.findById(id).get();

        detail.setQuantiteArticle(request.getQuantiteArticle());
        detail.setSousTotalDetailArticle(request.getSousTotalDetailArticle());
        detail.setSousTotalDetailArticleApresPromo(request.getSousTotalDetailArticleApresPromo());

        DetailCommande updated = detailCommandeRepository.save(detail);
        return detailCommandeMapper.toDto(updated);
    }

    @Override
    public void deleteDetailCommandeById(long id) {
        detailCommandeRepository.deleteById(id);
    }

    @Override
    public void deleteAllDetailCommande() {
        detailCommandeRepository.deleteAll();
    }

    @Override
    public long countDetailCommande() {
        return detailCommandeRepository.count();
    }

    @Override
    public boolean verifDetailCommandeById(long id) {
        return detailCommandeRepository.existsById(id);
    }

    @Override
    public List<DetailCommandeResponse> findByQuantiteExact(int qty) {
        return detailCommandeRepository.findByQuantiteExact(qty)
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> findBySousTotalExact(float st) {
        return detailCommandeRepository.findBySousTotalExact(st)
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public long countQuantityGreater(int qty) {
        return detailCommandeRepository.countQuantityGreater(qty);
    }

    @Override
    public boolean existsBySousTotalGreater(float st) {
        return detailCommandeRepository.existsBySousTotalGreater(st);
    }

    @Override
    public List<DetailCommandeResponse> findByQuantiteRangeAndSousTotal(int min, int max, float stMin) {
        return detailCommandeRepository.findByQuantiteRangeAndSousTotal(min, max, stMin)
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> findBySousTotalRangeOrderByQty(float min, float max) {
        return detailCommandeRepository.findBySousTotalRangeOrderByQty(min, max)
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> findBySousTotalPromoRange(float min, float max) {
        return detailCommandeRepository.findBySousTotalPromoRange(min, max)
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> findByQtyOrSousTotalMin(int qty, float st) {
        return detailCommandeRepository.findByQtyOrSousTotalMin(qty, st)
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> top5Expensive() {
        return detailCommandeRepository.findTop5Expensive()
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> findQuantityNull() {
        return detailCommandeRepository.findQuantityNull()
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> findSousTotalPromoNotNull() {
        return detailCommandeRepository.findSousTotalPromoNotNull()
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DetailCommandeResponse> findWithCommandeAndArticle() {
        return detailCommandeRepository.findWithCommandeAndArticle()
                .stream().map(detailCommandeMapper::toDto).collect(Collectors.toList());
    }

}
