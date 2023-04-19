package com.example.vindecoder_app

import kotlinx.coroutines.test.runTest
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VinDecoderUTtest
{
    lateinit var mockWebServer: MockWebServer
    lateinit var vehicleAPI:Vehicleapi

    @Before
    fun setUp()
    {
        mockWebServer= MockWebServer()
        vehicleAPI= Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Vehicleapi::class.java)
    }
    @Test
    fun testGetVinDetails()= runTest{
        val mockResponse= MockResponse()
        val  res:String="{\n" +
                "\"Count\": 1,\n" +
                "\"Message\": \"Results returned successfully. NOTE: Any missing decoded values should be interpreted as NHTSA does not have data on the specific variable. Missing value should NOT be interpreted as an indication that a feature or technology is unavailable for a vehicle.\",\n" +
                "\"SearchCriteria\": \"VIN(s): JNKCA21A4XT770979\",\n" +
                "\"Results\": [\n" +
                "{\n" +
                "\"ABS\": \"\",\n" +
                "\"ActiveSafetySysNote\": \"\",\n" +
                "\"AdaptiveCruiseControl\": \"\",\n" +
                "\"AdaptiveDrivingBeam\": \"\",\n" +
                "\"AdaptiveHeadlights\": \"\",\n" +
                "\"AdditionalErrorText\": \"\",\n" +
                "\"AirBagLocCurtain\": \"\",\n" +
                "\"AirBagLocFront\": \"1st Row (Driver and Passenger)\",\n" +
                "\"AirBagLocKnee\": \"\",\n" +
                "\"AirBagLocSeatCushion\": \"\",\n" +
                "\"AirBagLocSide\": \"1st Row (Driver and Passenger)\",\n" +
                "\"AutoReverseSystem\": \"\",\n" +
                "\"AutomaticPedestrianAlertingSound\": \"\",\n" +
                "\"AxleConfiguration\": \"\",\n" +
                "\"Axles\": \"\",\n" +
                "\"BasePrice\": \"\",\n" +
                "\"BatteryA\": \"\",\n" +
                "\"BatteryA_to\": \"\",\n" +
                "\"BatteryCells\": \"\",\n" +
                "\"BatteryInfo\": \"\",\n" +
                "\"BatteryKWh\": \"\",\n" +
                "\"BatteryKWh_to\": \"\",\n" +
                "\"BatteryModules\": \"\",\n" +
                "\"BatteryPacks\": \"\",\n" +
                "\"BatteryType\": \"\",\n" +
                "\"BatteryV\": \"\",\n" +
                "\"BatteryV_to\": \"\",\n" +
                "\"BedLengthIN\": \"\",\n" +
                "\"BedType\": \"Not Applicable\",\n" +
                "\"BlindSpotIntervention\": \"\",\n" +
                "\"BlindSpotMon\": \"\",\n" +
                "\"BodyCabType\": \"Not Applicable\",\n" +
                "\"BodyClass\": \"Sedan/Saloon\",\n" +
                "\"BrakeSystemDesc\": \"\",\n" +
                "\"BrakeSystemType\": \"\",\n" +
                "\"BusFloorConfigType\": \"Not Applicable\",\n" +
                "\"BusLength\": \"\",\n" +
                "\"BusType\": \"Not Applicable\",\n" +
                "\"CAN_AACN\": \"\",\n" +
                "\"CIB\": \"\",\n" +
                "\"CashForClunkers\": \"\",\n" +
                "\"ChargerLevel\": \"\",\n" +
                "\"ChargerPowerKW\": \"\",\n" +
                "\"CoolingType\": \"\",\n" +
                "\"CurbWeightLB\": \"\",\n" +
                "\"CustomMotorcycleType\": \"Not Applicable\",\n" +
                "\"DaytimeRunningLight\": \"\",\n" +
                "\"DestinationMarket\": \"\",\n" +
                "\"DisplacementCC\": \"3000\",\n" +
                "\"DisplacementCI\": \"183.0712322841\",\n" +
                "\"DisplacementL\": \"3\",\n" +
                "\"Doors\": \"4\",\n" +
                "\"DriveType\": \"\",\n" +
                "\"DriverAssist\": \"\",\n" +
                "\"DynamicBrakeSupport\": \"\",\n" +
                "\"EDR\": \"\",\n" +
                "\"ESC\": \"\",\n" +
                "\"EVDriveUnit\": \"\",\n" +
                "\"ElectrificationLevel\": \"\",\n" +
                "\"EngineConfiguration\": \"V-Shaped\",\n" +
                "\"EngineCycles\": \"\",\n" +
                "\"EngineCylinders\": \"6\",\n" +
                "\"EngineHP\": \"\",\n" +
                "\"EngineHP_to\": \"\",\n" +
                "\"EngineKW\": \"\",\n" +
                "\"EngineManufacturer\": \"Nissan\",\n" +
                "\"EngineModel\": \"VQ30\",\n" +
                "\"EntertainmentSystem\": \"\",\n" +
                "\"ErrorCode\": \"0\",\n" +
                "\"ErrorText\": \"0 - VIN decoded clean. Check Digit (9th position) is correct\",\n" +
                "\"ForwardCollisionWarning\": \"\",\n" +
                "\"FuelInjectionType\": \"\",\n" +
                "\"FuelTypePrimary\": \"Gasoline\",\n" +
                "\"FuelTypeSecondary\": \"\",\n" +
                "\"GCWR\": \"\",\n" +
                "\"GCWR_to\": \"\",\n" +
                "\"GVWR\": \"\",\n" +
                "\"GVWR_to\": \"\",\n" +
                "\"KeylessIgnition\": \"\",\n" +
                "\"LaneCenteringAssistance\": \"\",\n" +
                "\"LaneDepartureWarning\": \"\",\n" +
                "\"LaneKeepSystem\": \"\",\n" +
                "\"LowerBeamHeadlampLightSource\": \"\",\n" +
                "\"Make\": \"INFINITI\",\n" +
                "\"MakeID\": \"480\",\n" +
                "\"Manufacturer\": \"NISSAN MOTOR COMPANY, LTD\",\n" +
                "\"ManufacturerId\": \"996\",\n" +
                "\"Model\": \"I30\",\n" +
                "\"ModelID\": \"8702\",\n" +
                "\"ModelYear\": \"1999\",\n" +
                "\"MotorcycleChassisType\": \"Not Applicable\",\n" +
                "\"MotorcycleSuspensionType\": \"Not Applicable\",\n" +
                "\"NCSABodyType\": \"\",\n" +
                "\"NCSAMake\": \"\",\n" +
                "\"NCSAMapExcApprovedBy\": \"\",\n" +
                "\"NCSAMapExcApprovedOn\": \"\",\n" +
                "\"NCSAMappingException\": \"\",\n" +
                "\"NCSAModel\": \"\",\n" +
                "\"NCSANote\": \"\",\n" +
                "\"NonLandUse\": \"\",\n" +
                "\"Note\": \"\",\n" +
                "\"OtherBusInfo\": \"\",\n" +
                "\"OtherEngineInfo\": \"\",\n" +
                "\"OtherMotorcycleInfo\": \"\",\n" +
                "\"OtherRestraintSystemInfo\": \"3-Point manual belts\",\n" +
                "\"OtherTrailerInfo\": \"\",\n" +
                "\"ParkAssist\": \"\",\n" +
                "\"PedestrianAutomaticEmergencyBraking\": \"\",\n" +
                "\"PlantCity\": \"YOKOSUKA CITY\",\n" +
                "\"PlantCompanyName\": \"Oppama Plant\",\n" +
                "\"PlantCountry\": \"JAPAN\",\n" +
                "\"PlantState\": \"KANAGAWA\",\n" +
                "\"PossibleValues\": \"\",\n" +
                "\"Pretensioner\": \"\",\n" +
                "\"RearAutomaticEmergencyBraking\": \"\",\n" +
                "\"RearCrossTrafficAlert\": \"\",\n" +
                "\"RearVisibilitySystem\": \"\",\n" +
                "\"SAEAutomationLevel\": \"\",\n" +
                "\"SAEAutomationLevel_to\": \"\",\n" +
                "\"SeatBeltsAll\": \"Manual\",\n" +
                "\"SeatRows\": \"\",\n" +
                "\"Seats\": \"\",\n" +
                "\"SemiautomaticHeadlampBeamSwitching\": \"\",\n" +
                "\"Series\": \"\",\n" +
                "\"Series2\": \"\",\n" +
                "\"SteeringLocation\": \"\",\n" +
                "\"SuggestedVIN\": \"\",\n" +
                "\"TPMS\": \"\",\n" +
                "\"TopSpeedMPH\": \"\",\n" +
                "\"TrackWidth\": \"\",\n" +
                "\"TractionControl\": \"\",\n" +
                "\"TrailerBodyType\": \"Not Applicable\",\n" +
                "\"TrailerLength\": \"\",\n" +
                "\"TrailerType\": \"Not Applicable\",\n" +
                "\"TransmissionSpeeds\": \"\",\n" +
                "\"TransmissionStyle\": \"\",\n" +
                "\"Trim\": \"\",\n" +
                "\"Trim2\": \"\",\n" +
                "\"Turbo\": \"\",\n" +
                "\"VIN\": \"JNKCA21A4XT770979\",\n" +
                "\"ValveTrainDesign\": \"\",\n" +
                "\"VehicleDescriptor\": \"JNKCA21A*XT\",\n" +
                "\"VehicleType\": \"PASSENGER CAR\",\n" +
                "\"WheelBaseLong\": \"\",\n" +
                "\"WheelBaseShort\": \"\",\n" +
                "\"WheelBaseType\": \"\",\n" +
                "\"WheelSizeFront\": \"\",\n" +
                "\"WheelSizeRear\": \"\",\n" +
                "\"Wheels\": \"\",\n" +
                "\"Windows\": \"\"\n" +
                "}\n" +
                "]\n" +
                "}"
        mockResponse.setBody(res)
        mockWebServer.enqueue(mockResponse)
        val response= vehicleAPI.getVinDetails(anyString())
        mockWebServer.takeRequest()
        Assert.assertEquals(true,response.body()?.Results?.get(0)?.VIN.equals("JNKCA21A4XT770979"))

    }
    @After
    fun teardown()
    {
        mockWebServer.shutdown()
    }

}
