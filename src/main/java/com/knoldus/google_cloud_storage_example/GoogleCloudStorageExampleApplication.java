/**
 * @author Ranu Rajput
 */
package com.knoldus.google_cloud_storage_example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Spring Resource abstraction and
 * the gs: protocol prefix are used in this Spring Boot application
 * to read and write files stored in Google Cloud Storage (GCS).
 */
@SpringBootApplication
public class GoogleCloudStorageExampleApplication {
	/**
	 * Main method for the Application
	 * @param args for taking input from command line
	 */
	public static void main(String[] args) {
		SpringApplication.run(GoogleCloudStorageExampleApplication.class, args);
	}
}
