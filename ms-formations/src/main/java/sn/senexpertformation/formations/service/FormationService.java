package sn.senexpertformation.formations.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import sn.senexpertformation.formations.dto.DemandeFormationDTO;
import sn.senexpertformation.formations.entity.DemandeFormation;
import sn.senexpertformation.formations.entity.Domaine;
import sn.senexpertformation.formations.entity.FormationALaCarte;
import sn.senexpertformation.formations.entity.OffreFormation;
import sn.senexpertformation.formations.repository.DemandeFormationRepository;
import sn.senexpertformation.formations.repository.DomaineRepository;
import sn.senexpertformation.formations.repository.FormationALaCarteRepository;
import sn.senexpertformation.formations.repository.OffreFormationRepository;

@Service
public class FormationService {

	private final DomaineRepository domaineRepository;
	private final OffreFormationRepository offreFormationRepository;
	private final DemandeFormationRepository demandeFormationRepository;
	private final FormationALaCarteRepository formationALaCarteRepository;

	public FormationService(DomaineRepository domaineRepository, OffreFormationRepository offreFormationRepository,
			DemandeFormationRepository demandeFormationRepository,
			FormationALaCarteRepository formationALaCarteRepository) {
		this.domaineRepository = domaineRepository;
		this.offreFormationRepository = offreFormationRepository;
		this.demandeFormationRepository = demandeFormationRepository;
		this.formationALaCarteRepository = formationALaCarteRepository;
	}

	// ===================== DOMAINE =====================

	public Domaine creerDomaine(Domaine domaine) {
		return domaineRepository.save(domaine);
	}

	public List<Domaine> getTousLesDomaines() {
		return domaineRepository.findAll();
	}

	// ===================== OFFRE FORMATION =====================

	public OffreFormation creerOffre(OffreFormation offre) {
		offre.setStatut("OUVERTE");
		return offreFormationRepository.save(offre);
	}

	public List<OffreFormation> getToutesLesOffres() {
		return offreFormationRepository.findAll();
	}

	public List<OffreFormation> getOffresOuvertes() {
		return offreFormationRepository.findByStatut("OUVERTE");
	}

	public OffreFormation fermerOffre(Long offreId) {
		OffreFormation offre = offreFormationRepository.findById(offreId)
				.orElseThrow(() -> new RuntimeException("Offre non trouvée"));
		offre.setStatut("FERMEE");
		return offreFormationRepository.save(offre);
	}

	// ===================== DEMANDE FORMATION =====================

	public DemandeFormation creerDemande(DemandeFormationDTO dto) {
		DemandeFormation demande = new DemandeFormation();
		demande.setDateDemande(LocalDate.now());
		demande.setType(dto.getType());
		demande.setStatut("EN_ATTENTE");
		demande.setUtilisateurId(dto.getUtilisateurId());
		demande.setInstitutionId(dto.getInstitutionId());

		if ("OFFRE_STANDARD".equals(dto.getType())) {
			// Demande sur une offre existante
			if (dto.getOffreFormationId() == null) {
				throw new RuntimeException("offreFormationId obligatoire pour une demande OFFRE_STANDARD");
			}
			OffreFormation offre = offreFormationRepository.findById(dto.getOffreFormationId())
					.orElseThrow(() -> new RuntimeException("Offre non trouvée"));
			demande.setOffreFormation(offre);

		} else if ("A_LA_CARTE".equals(dto.getType())) {
			// Demande personnalisée — on sauvegarde d'abord la demande
			DemandeFormation saved = demandeFormationRepository.save(demande);

			// Puis on crée la formation à la carte liée
			FormationALaCarte alaCarte = new FormationALaCarte();
			alaCarte.setBesoinSpecifique(dto.getBesoinSpecifique());
			alaCarte.setDomaineSouhaiteId(dto.getDomaineSouhaiteId());
			alaCarte.setDemandeFormation(saved);
			formationALaCarteRepository.save(alaCarte);

			return saved;
		} else {
			throw new RuntimeException("Type de demande invalide : utilisez OFFRE_STANDARD ou A_LA_CARTE");
		}

		return demandeFormationRepository.save(demande);
	}

	public DemandeFormation validerDemande(Long demandeId, Long agentValidationId) {
		DemandeFormation demande = demandeFormationRepository.findById(demandeId)
				.orElseThrow(() -> new RuntimeException("Demande non trouvée"));
		demande.setStatut("VALIDEE");
		demande.setAgentValidationId(agentValidationId);
		return demandeFormationRepository.save(demande);
	}

	public DemandeFormation rejeterDemande(Long demandeId, Long agentValidationId) {
		DemandeFormation demande = demandeFormationRepository.findById(demandeId)
				.orElseThrow(() -> new RuntimeException("Demande non trouvée"));
		demande.setStatut("REJETEE");
		demande.setAgentValidationId(agentValidationId);
		return demandeFormationRepository.save(demande);
	}

	public List<DemandeFormation> getDemandesEnAttente() {
		return demandeFormationRepository.findByStatut("EN_ATTENTE");
	}

	public List<DemandeFormation> getDemandesParUtilisateur(Long utilisateurId) {
		return demandeFormationRepository.findByUtilisateurId(utilisateurId);
	}
}