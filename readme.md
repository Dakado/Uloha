# Prime Finder

Prime finder is a simple Java command-line app to find all prime numbers in the given .xlsx file.

## Usage

You can start the application by using on of the included start scripts, for windows `start.bat` or for linux `start.sh`.
Start files are preconfigures to pass `vzorek_dat.xlsx` as runtime argument which refers to the input data file.

## Configuration

Config file `config.yaml` allows you to configure sheet, column and starting row where the program will start reading input numbers. All non-numeric values are silently ignored.

## Sample output

    java -jar target\Uloha-1.0-jar-with-dependencies.jar vzorek_dat.xlsx
    Input file 'vzorek_dat.xlsx' is valid.
    Config config.yaml loaded successfully!
    Searching input values at index 0:1:1 (sheet:column:row)...
    5645657
    15619
    1234187
    211
    7
    9788677
    23311
    54881
    In total found 8 prime numbers out of 17 numbers given as input.

