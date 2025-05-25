package com.bms.dbapi.responsebody;

import com.bms.dbapi.models.Show;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ShowsByHallIdRB {

    List<Show> shows;
}
