#include <main.h>

int main() {
    std::cout << "Simple program that accepts user input and does something with it." << std::endl;
    std::cout << "At any time if instructed, insert 'quit' (or 0) to exit the program, or 'repeat' (or 1) to repeat the question." << std::endl << std::endl;

    ExampleInput e;

    unsigned int intInput = e.getInteger("Please insert some kind of number that you'd like to be returned to you.");
    std::cout << "You entered: " << intInput << std::endl;

    std::string strInput = e.getInput("Please insert some kind of thing that you'd like to be returned to you.");
    std::cout << "You entered: "  << strInput << std::endl;

    std::cout << "Time to do some maths!" << std::endl;

    int userAnswer = 0;
    int answer = 0;
    unsigned int goodAnswers = 0;
    unsigned int wrongAnswers = 0;

    while (goodAnswers < 3) {
        Equation *eq = new Equation();

        answer = eq->getAnswer();

        while (answer != userAnswer) {
            userAnswer = e.getInteger("How much is " + eq->getEquation() + "?");

            if (answer != userAnswer) {
                std::cout << "Nope, that's not correct." << std::endl;
                wrongAnswers++;
            } else {
                std::cout << "You're the best!" << std::endl;
                goodAnswers++;
                break;
            }
        }

        delete eq;
    }

    std::cout << "Good job! You got " << goodAnswers << " correct answers and " << wrongAnswers << " wrong answers.";
    return 0;
}