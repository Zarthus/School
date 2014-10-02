#include <exampleinput.h>

ExampleInput::ExampleInput() {}
ExampleInput::~ExampleInput() {}

std::string ExampleInput::getInput() {
    std::string input;
    int iters;

    std::cout << "Insert 'quit' to exit the program." << std::endl <<  "> ";
    for (iters = 0; iters < 10; iters++) {
        std::cin >> input;

        if (!std::cin) {
            std::cout << std::endl << "Erroneous input, please try again." << std::endl;
            continue;
        }

        if (input.empty()) {
            std::cout << std::endl << "Input was empty." << std::endl;
            continue;
        }

        if (StringUtils::bicompare(input, "quit")) {
            std::cout << std::endl << "Exiting.." << std::endl;
            exit(0);
        }

        break;
    }

    return input; /* this will return an empty string if no valid input was given. */
}

std::string ExampleInput::getInput(std::string prompt) {
    std::string input;
    int iters;

    std::cout << "Insert 'quit' to exit the program, or 'repeat' to repeat the question." << std::endl;
    Prompt::prompt(prompt);
    for (iters = 0; iters < 10; iters++) {
        std::cin >> input;

        if (!std::cin) {
            std::cout << std::endl << "Erroneous input, please try again." << std::endl;
            continue;
        }

        if (input.empty()) {
            std::cout << std::endl << "Input was empty." << std::endl;
            continue;
        }

        if (StringUtils::bicompare(input, "repeat")) {
            Prompt::prompt(prompt);
            continue;
        }

        if (StringUtils::bicompare(input, "quit")) {
            std::cout << std::endl << "Exiting.." << std::endl;
            exit(0);
        }

        break;
    }

    return input; /* this will return an empty string if no valid input was given. */
}

unsigned int ExampleInput::getInteger() {
    unsigned int input = 0;
    int iters;

    std::cout << "Insert '0' to exit the program." << std::endl << "> ";
    for (iters = 0; iters < 10; iters++) {
        std::cin >> input;

        /*
        *  when using 'continue' and inserting a string, the code would skip std::cin; not fetching new input.
        *  I'm not sure what the cause is.
        **/
        if (!std::cin) {
            std::cout << std::endl << "Erroneous input, please try again." << std::endl;
            input = 0;
            break;
        }

        if (input == 0) {
            std::cout << std::endl << "Exiting.." << std::endl;
            exit(0);
        }

        break;
    }

    return input; /* this will return a 0 if no valid input was given. If the user inserts this number, the program will exit. */
}

unsigned int ExampleInput::getInteger(std::string prompt) {
    unsigned int input = 0;
    int iters;

    std::cout << "Insert '0' to exit the program, or '1' to repeat the question." << std::endl;
    Prompt::prompt(prompt);
    for (iters = 0; iters < 10; iters++) {
        std::cin >> input;

        /*
        *  when using 'continue' and inserting a string, the code would skip std::cin; not fetching new input.
        *  I'm not sure what the cause is.
        **/
        if (!std::cin) {
            std::cout << std::endl << "Erroneous input, please try again. Defaulting to 0!" << std::endl;
            input = 0;
            break;
        }

        if (input == 1) {
            Prompt::prompt(prompt);
            continue;
        }

        if (input == 0) {
            std::cout << std::endl << "Exiting.." << std::endl;
            exit(0);
        }

        break;
    }

    return input; /* this will return a 0 if no valid input was given. If the user inserts this number, the program will exit. */
}
