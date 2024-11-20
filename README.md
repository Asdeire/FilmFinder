# Film Finder

## Topic

Creating a Single Page Application (SPA) for displaying movie information.

## Objective

To build a RESTful application integrated with a frontend framework, enabling movie search and email functionality.

## Features

- Users can search for a movie by entering its title.
- The app fetches movie details using the [OMDb API](http://www.omdbapi.com/).
- Users can send the movie information via email by specifying the recipient, subject, and message body.

## Technologies Used

- **Java**: Backend programming language.
- **Spring Boot**: For RESTful API development.
- **Frontend Framework**: A modern framework (e.g., React or Angular) for building the SPA.
- **OMDb API**: External API for movie data retrieval.
- **Email Integration**: Using Spring Mail or a similar library for sending emails.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/movie-info-spa.git
   cd movie-info-spa
   ```

2. Set up the OMDb API key:
   - Register on [OMDb API](http://www.omdbapi.com/) to obtain an API key.
   - Add the key to the application properties file:
     ```
     omdb.api.key=your_api_key
     ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application at `http://localhost:8080`.

## Usage

1. Enter the movie title in the search bar.
2. View movie details retrieved from the OMDb API.
3. To share the movie information:
   - Enter the recipient's email address.
   - Provide a subject and a message body.
   - Send the email.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with any enhancements or fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
