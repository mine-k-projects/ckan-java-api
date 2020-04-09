package minek.ckan.v3.basic.service;

import lombok.NonNull;
import minek.ckan.v3.basic.model.Member;
import minek.ckan.v3.basic.model.enums.Capacity;
import minek.ckan.v3.basic.model.enums.ObjectType;
import minek.ckan.v3.basic.service.command.create.GroupMemberCreate;
import minek.ckan.v3.basic.service.command.create.MemberCreate;
import minek.ckan.v3.basic.service.command.delete.GroupMemberDelete;
import minek.ckan.v3.basic.service.command.delete.MemberDelete;
import minek.ckan.v3.basic.service.command.delete.OrganizationMemberDelete;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface MemberService {

    @POST("api/3/action/group_member_create")
    Call<Member> groupMemberCreate(@Body GroupMemberCreate groupMemberCreate);

    @POST("api/3/action/group_member_delete")
    Call<Void> groupMemberDelete(@Body GroupMemberDelete groupMemberDelete);

    @POST("api/3/action/member_create")
    Call<Member> memberCreate(@Body MemberCreate memberCreate);

    @POST("api/3/action/member_delete")
    Call<Void> memberDelete(@Body MemberDelete memberDelete);

    @GET("api/3/action/member_list")
    Call<List<Member>> memberList(@NonNull @Query("id") String groupIdOrGroupName,
                                  @Query("type") ObjectType type,
                                  @Query("capacity") Capacity capacity);

    default Call<List<Member>> memberList(@NonNull String groupIdOrGroupName) {
        return memberList(groupIdOrGroupName, null, null);
    }

    @POST("api/3/action/organization_member_create")
    Call<Member> organizationMemberCreate(@Body GroupMemberCreate groupMemberCreate);

    @POST("api/3/action/organization_member_delete")
    Call<Void> organizationMemberDelete(@Body OrganizationMemberDelete organizationMemberDelete);

}
