// package com.foodforcharity.app.infrastructure;

// import java.util.Optional;

// import com.foodforcharity.app.domain.constant.DonorStatus;
// import com.foodforcharity.app.domain.entity.Donor;
// import com.foodforcharity.app.domain.security.JwtProvider;
// import com.foodforcharity.app.domain.security.PersonDetails;
// import com.foodforcharity.app.domain.security.PersonDetailsService;
// import com.foodforcharity.app.infrastructure.repository.DonorRepository;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class PersonDetailsServiceTest {

//     @Autowired
//     PersonDetailsService service;

//     @Autowired
//     DonorRepository repos;

//     @Autowired
//     JwtProviderService jwtProvider;

//     Donor donor = null;

//     @Before
//     public void init() {

//         Optional<Donor> dbDonor = repos.findByUsername("donoremail@gmail.com");

//         if (dbDonor.isPresent())
//             donor = dbDonor.get();
//         else {

//             donor = new Donor();
//             donor.setAddressDescription("DonorAddressDescription");
//             donor.setCity("DonorCity");
//             donor.setCountry("DonorCountry");
//             donor.setDonorName("DonorName");
//             donor.setDonorStatus(DonorStatus.Initial);
//             donor.setEmail("donoremail@gmail.com");
//             donor.setNumberOfRating(0);
//             donor.setPassword("DonorPassword");
//             donor.setPhoneNumber("DonorPhoneNumber");
//             donor.setRating(0);
//             donor.setUsername(donor.getEmail());
//             donor.setDiscountApplied(0);

//             donor = repos.save(donor);
//         }
//     }

//     @Test
//     public void loadUserByUsernameSuccessTest() {
//         PersonDetails personDetail = service.loadUserByUsername(donor.getUsername());
//         assert (personDetail.getPersonId() == donor.getId());
//     }

//     @Test
//     public void reterieveJWTSuccessTest() {
//         PersonDetails personDetail = service.loadUserByUsername(donor.getUsername());

//         String jwt = jwtProvider.createToken(personDetail);

//         personDetail = service.loadUserByJwtToken(jwt).orElseThrow();

//         Object[] auth = personDetail.getAuthorities().toArray();
//         assert(auth[0].toString().equals("Donor") || auth[1].toString().equals("Donor"));
//         assert(auth[0].toString().equals(donor.getStatus().get()) || auth[1].toString().equals(donor.getStatus().get()));

//         assert (personDetail.getPersonId() == donor.getId());
//     }

// }