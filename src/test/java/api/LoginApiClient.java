public static long login() {

    String body = """
    {
      "email": "eve.holt@reqres.in",
      "password": "cityslicka"
    }
    """;

    long start = System.currentTimeMillis();

    try {
        Response response =
                given()
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .post("/api/login");

        long duration = System.currentTimeMillis() - start;

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("API returned non-200 status: " + response.getStatusCode());
        }

        return duration;

    } catch (Exception e) {
        throw new RuntimeException("API call failed in CI environment", e);
    }
}
