/*
 * package com.bae.business;
 * 
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.Assert.assertEquals; import java.util.Arrays; import
 * org.junit.Before; import org.junit.Test; import org.junit.runner.RunWith;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.bae.business.TeamPlayerService; import
 * com.bae.persistence.domain.TeamPlayer; import
 * com.bae.persistence.repo.TeamPlayerRepository;
 * 
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class TeamPlayerServiceIntegrationTest {
 * 
 * 
 * @Autowired private TeamPlayerService service;
 * 
 * @Autowired private TeamPlayerRepository playerRepo;
 * 
 * private TeamPlayer testTeamPlayer;
 * 
 * private TeamPlayer testTeamPlayerWithID;
 * 
 * @Before public void init() { this.testTeamPlayer = new
 * TeamPlayer("Spongebob", "Squarepants");
 * 
 * this.playerRepo.deleteAll();
 * 
 * this.testTeamPlayerWithID = this.playerRepo.save(this.testTeamPlayer); }
 * 
 * @Test public void testAddNewPlayer() {
 * assertEquals(this.testTeamPlayerWithID,
 * this.service.addNewPlayer(testTeamPlayer)); }
 * 
 * @Test public void testDeletePlayer() {
 * assertThat(this.service.deletePlayer(this.testTeamPlayerWithID.getId())).
 * isFalse(); }
 * 
 * @Test public void testFindPlayerByID() {
 * assertEquals(this.service.findPlayerByID(this.testTeamPlayerWithID.getId()).
 * toString(), this.testTeamPlayerWithID.toString()); }
 * 
 * @Test public void testGetAllTeamPlayer() {
 * assertThat(this.service.getAllPlayer().toString()).isEqualTo(Arrays.asList(
 * new TeamPlayer[] {this.testTeamPlayerWithID }).toString()); }
 * 
 * @Test public void testUpdateTeamPlayer() { TeamPlayer newTeamPlayer = new
 * TeamPlayer("Dora", "Explorer"); TeamPlayer updatedTeamPlayer = new
 * TeamPlayer(newTeamPlayer.getFirstName(), newTeamPlayer.getSurname());
 * updatedTeamPlayer.setId(this.testTeamPlayerWithID.getId());
 * 
 * assertThat(this.service.updatePlayer(newTeamPlayer,
 * this.testTeamPlayerWithID.getId()).toString()).isEqualTo(updatedTeamPlayer.
 * toString()); }
 * 
 * 
 * }
 */