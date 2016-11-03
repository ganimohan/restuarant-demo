# restuarant-demo

The application is developed using spring-boot. The application can use different types of datasources. As for this exercise, 
FileInputDataSource is used. The data.txt file provided is used as a reference.

Output of this exercise will be 2448727

Initially file is parsed and the contents are added to a SortedSet. Note: While adding the same, the contents are sorted by ascending order of time.
The function also is defined as part of the configuration which returns a bean of type Menu.

While processing the request, we iterate through the dishes and use knapsack algo to compute the satisfaction factor.
