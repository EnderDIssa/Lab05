package commands

import movies.*
import java.util.Scanner

class AddIfMaxCommand(private val movieManager: MovieManager): Command {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is adding element, if it's value more then maximum\n" +
            "[Command]: add_if_max"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "add_if_max"

    /**
     * Execute command abstract method.
     *
     * @param arguments if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(vararg arguments: String?): Boolean {
        val scanner = Scanner(System.`in`)
        print("Input film name: ")
        val name = scanner.nextLine()
        print("Input coordinates: ")
        print("X: ")
        val xcoord = scanner.nextFloat()
        print("Y: ")
        val ycoord = scanner.nextDouble()
        print("Oscars count: ")
        val oscarsCount = scanner.nextLong()
        print("Length: ")
        val lenght = scanner.nextInt()
        print("Genre: ")
        val genre = MovieGenre.valueOf(scanner.nextLine())
        print("Mpaa rating: ")
        val mpaaRating = MpaaRating.valueOf(scanner.nextLine())
        println("Person:")
        print("Name: ")
        val personName = scanner.nextLine()
        print("Height: ")
        val personHeight = scanner.nextInt()
        print("Hair color: ")
        val personColor = Color.valueOf(scanner.nextLine())
        print("Nationality: ")
        val personNationality = Country.valueOf(scanner.nextLine())

        val movies = movieManager.getMovieQueue()
        var maxValue:Long=-1
        for (movie in movies){
            if (movie.getOscarsCount()>maxValue){
                maxValue=movie.getOscarsCount()
            }
        }
        if (maxValue>oscarsCount){
            movieManager.addMovie(Movie(name, Coordinates(xcoord, ycoord), oscarsCount, lenght, genre, mpaaRating,
                Person(personName, personHeight, personColor, personNationality)))
            return true
        }
    return false
    }
}