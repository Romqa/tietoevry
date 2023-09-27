# Readme

## Startup
> ./gradlew bootRun

## Usage
### Requests
#### GET:/things

| parameter    | type      | example    | description              |
|--------------|-----------|------------|--------------------------|
| location     | String    | Madeira    | Location of the trip     |
| date         | LocalDate | 2023-10-01 | Start date of the trip   |
| distanceInKm | int       | 100        | Trip distance in km      |
| peopleCount  | int       | 2          | People count in the trip |
| type         | enum      | HIKING     | TREKKING / HIKING        |

Example:
> curl 'http://localhost:8088/things?location=Madeira&date=2023-10-01&distanceInKm=100&peopleCount=2&type=HIKING'

### Response
```json
{
    "food": [
        {
            "title": "Breakfast pack",
            "amount": 3.0,
            "measure": "PCS"
        },
        {
            "title": "Dinner pack",
            "amount": 3.0,
            "measure": "PCS"
        },
        {
            "title": "Lunch pack",
            "amount": 4.0,
            "measure": "PCS"
        },
        {
            "title": "Snacks",
            "amount": 8.0,
            "measure": "PCS"
        },
        {
            "title": "Water",
            "amount": 2.0,
            "measure": "L"
        }
    ],
    "clothes": [
        {"title": "Sunhat"},
        {"title": "Rainwear"},
        {"title": "Waterproof high shoes"}
    ],
    "equipments": [
        {"title": "Flashlight"},
        {"title": "Tent for 2 people"}
    ]
}
```


## Todo
- [ ] More tests
- [ ] Add @ControllerAdvice for exception handling
- [ ] Add WireMock for testing using WeatherComApi
- [ ] Todos inside the code