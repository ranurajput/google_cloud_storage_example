# google_cloud_storage_example

Using the Spring Cloud GCP Storage Starter, 
this code example shows how to read and write files using the Spring Resource abstraction for Google Cloud Storage.


1. Make sure that you have the Cloud SDK configured by following https://cloud.google.com/sdk/docs/[these instructions].

2. Create a new bucket in Google Cloud Storage.
You can use the `gsutil` command that comes with the Cloud SDK.
+
```
$ BUCKET=spring-bucket-$USER
$ gsutil makebucket gs://$BUCKET
```

3. Transfer the local `MyFile.txt` file to the bucket.
+
```
$ gsutil copy my-file.txt gs://$BUCKET
```

4. Run `$ mvn clean install` from the root directory of the project.

5. In the same directory ,edit the
`src/main/resources/application.properties` and set the `gcs-resource-test-bucket` property to the name of your bucket
that you created in Step 2.

6. Start the `GcsApplication` Spring Boot app.
+
```
$ mvn spring-boot:run
```

7. Navigate to http://localhost:9090/ in your browser to print the contents of the file you uploaded in 3. You can also
use the `Web Preview` button in Cloud Shell to preview the app on port 9090.this port no. is mentioned in Application.prpperties file.

8. To update the file contents, send a POST request to the same endpoint using `curl`:
+
```
$ curl -d 'new message' -H 'Content-Type: text/plain' localhost:9090
```
+
You should see a confirmation that the contents of the file were updated.
+
let's verify by going to http://localhost:9090/ or the `Web Preview` URL.
