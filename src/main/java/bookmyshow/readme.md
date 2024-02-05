# Book My Show - Low Level Design

## Functional Requirements

* Support multiple cities.
* Display different movies shows in different cities.
* For a given city, display available theatres and shows in those theatres.
* One city can have multiple theatres.
* One theatre can have multiple auditoriums.
* One audi will have multiple seats.
* Seats can be of different type:
  * SILVER
  * GOLD
  * PLATINUM
* Theatres should be able to name their seat types.
* Price of a seat depends on the time of the show, theatre and type of the seat.
* One user can select maximum 10 seats at a time.
* Different auditorium can have different seat structure.
* No admin functionality in this version.
* Store cast and rating information of a movie:
  * Rating
  * Duration
  * Features (2D, 3D, IMAX, Doubly, Subtitles)
  * Language
  * Cast
* Only allow booking before 30 minutes of the show-time.
* Booking allowed for one show at a time.
* Can have different seat type in the same booking
* User can cancel ticket and get refund.


## Entity Identification

* City
   - id
   - name
   - List<Theatre>
* Theatre
   - id
   - name
   - Address
   - City
   - List<Auditorium>
* Auditorium
   - id
   - name
   - Theatre
   - List<Seat>
   - List<Feature> - enum (2D, 3D, DOLBY AUDIO)
   - List<Show>
* Seat
   - id
   - seatNumber
   - row
   - column
   - Auditorium
   - Type
* SeatType
   - id
   - name
* Show
   - id
   - name
   - Movie
   - Auditorium
   - startTime
   - endTime
   - Language
* Movie
   - id
   - name
   - Cast
   - releaseDate
   - List<Language>
* Cast
   - id
   - List<Actor>
* Language
   - id
   - name
* User
   - id
   - name
   - age
   - phone
   - email
* Booking
   - id
   - Show
   - User
   - List<Payment>
   - status (BOOKED, CANCELLED, OVER)
   - List<Ticket>
* Ticket
   - id
   - Booking
   - Seat
* Payment
   - id
   - amount
   - Booking
   - Mode
   - providerId
   - paymentType ( REFUND, PAY)
   - Status (IN_PROGRESS, COMPLETED, FAILED, REFUNDED)
* Show_Seat
   - id
   - Show
   - Seat
* ShowSeatType
   - id
   - Show
   - SeatType
   - price

## Schema Design

* City
  - id: number - autoincrement - PK
  - name: varchar2(100)
* Address:
  - id
  - address
  - pincode
  - latitude
  - longitude
  - city_id - FK
* Theatre
  - id: number - autoincrement - PK
  - name: varchar(100)
  - address_id - FK
* Auditorium
  - id: number - autoincrement - PK
  - name: varchar(250)
  - theatre_id - FK
* Feature
  - id: number - autoincrement - PK
  - feature_type - varchar(20) 
* Auditorium_Feature
  - id: number - autoincrement - PK
  - auditorium_id - FK - indexed
  - feature_id - FK
* Seat
  - id: number - autoincrement - PK
  - seatNumber: varchar(20)
  - row: number
  - column: number
  - auditorium_id - FK
  - seat_type_id
* Seat_Type
  - id: number - autoincrement - PK
  - name: varchar(20) - SILVER, GOLD, PLATINUM
* Auditorium_Seat
  - id: number - autoincrement - PK
  - auditorium_id - FK - indexed
  - seat_id - FK - unique
* Show
  - id: number - autoincrement - PK
  - name: varchar(100)
  - movie_id  - FK
  - auditorium_id - FK
  - startTime: DateTime
  - endTime: DateTime
  - language_id
* Language
  - id: number - autoincrement - PK
  - name: varchar(50)
* Movie
  - id: number - autoincrement - PK
  - name: varchar(500)
  - cast_id - FK
  - releaseDate: DateTime
* Movie_Language
  - id
  - movie_id - FK - indexed
  - language_id - FK
* Cast
  - id: number - autoincrement - PK
  - movie_id - FK - indexed
  - actor_id - FK - indexed
* Actor
 - id: number - autoincrement - PK
 - name: varchar(500)
* User
 - id: number - autoincrement - PK
 - name: varchar(500)
 - age: number
 - phone: varchar(20)
 - email: varchar(100)
 - password: varchar(50)
* Booking
 - id: number - autoincrement - PK
 - show_id - FK - indexed
 - user_id - FK - indexed
 - status_id - FK
 - bookingDate: DateTime
 - numberOfSeats: number
* Ticket
 - id: number - autoincrement - PK
 - booking_id - FK - indexed
 - seat_id - FK
* Payment
 - id: number - autoincrement - PK
 - amount: double
 - booking_id - FK
 - mode_id - ENUM - UPI, PayPal, PayUMoney
 - providerId - varchar(200)
 - payment_type_id - ENUM - PAYMENT, REFUND
 - payment_status_id - ENUM - IN_PROGRESS, COMPLETED, FAILED, REFUNDED
* show_seat
 - id: number - autoincrement - PK
 - show_id - FK
 - seat_id - FK
* show_seat_type
 - id: number - autoincrement - PK
 - show_id - FK
 - seat_type_id - FK
 - price: double

