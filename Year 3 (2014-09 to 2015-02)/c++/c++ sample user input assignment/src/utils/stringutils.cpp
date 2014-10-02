#include <stringutils.h>

StringUtils::StringUtils()
{

}

StringUtils::~StringUtils()
{

}

std::string StringUtils::tolower(const std::string str)
{
    std::string lstr = str;

    std::transform(lstr.begin(), lstr.end(), lstr.begin(), ::tolower);

    return lstr;
}

std::string StringUtils::toupper(const std::string str)
{
    std::string ustr = str;

    std::transform(ustr.begin(), ustr.end(), ustr.begin(), ::toupper);

    return ustr;
}

int StringUtils::icompare(const std::string str1, const std::string str2)
{
    return StringUtils::tolower(str1).compare(StringUtils::tolower(str2));
}

bool StringUtils::bicompare(const std::string str1, const std::string str2)
{
    return StringUtils::icompare(str1, str2) == 0;
}